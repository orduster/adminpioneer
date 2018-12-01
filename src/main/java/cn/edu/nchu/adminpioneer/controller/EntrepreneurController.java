package cn.edu.nchu.adminpioneer.controller;

import cn.edu.nchu.adminpioneer.entity.Entrepreneur;
import cn.edu.nchu.adminpioneer.service.EntrepreneurService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/adminpioneer/admin")
public class EntrepreneurController {

    /*存储文件目录*/
    @Value("${file.path}")
    private String filePath;

    @Autowired
    private EntrepreneurService service;

    /*来到标兵页面*/
    @GetMapping("/entrepreneurList")
    public String Entrepreneurs() {
        return "entrepreneur";
    }

    /*得到所有标兵*/
    @PostMapping(value = "/entrepreneurList", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> getAllEntrepreneur(@RequestBody JSONObject jsonObject) {
        int pageSize = jsonObject.getIntValue("pageSize");//每页显示数
        int offset = jsonObject.getIntValue("offset");//页码
        Map<String, Object> map = new HashMap<>();
        List<Entrepreneur> entrepreneurs = service.showEntrepreneur(pageSize, offset);
        int count = service.countEntrepreneur();
        map.put("total", count);
        map.put("rows", entrepreneurs);
        return map;
    }

    /*来到添加页面*/
    @GetMapping("/entrepreneur")
    public String toAddPage() {
        return "addEntrepreneur";
    }

    //添加团队
    @PostMapping(value = "/entrepreneur")
    public String addEntrepreneur(@RequestParam("file") MultipartFile multipartFile,
                                  @RequestParam("name") String name,
                                  @RequestParam("introduction") String introduction,
                                  @RequestParam("content") String content,
                                  @RequestParam("text") String text,
                                  RedirectAttributes redirectAttributes) {
        if (multipartFile.isEmpty()) {
            redirectAttributes.addFlashAttribute("msg", "上传失败，文件为空！");
            return "redirect:/adminpioneer/admin/entrepreneurList";
        }
        try {
            //得到和存储文件
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(filePath + multipartFile.getOriginalFilename());
            Files.write(path, bytes);
            Entrepreneur entrepreneur = new Entrepreneur(name, introduction, "/images/" + multipartFile.getOriginalFilename(), content, text);
            int i = service.addEntrepreneur(entrepreneur);
            if (i > 0) {
                redirectAttributes.addFlashAttribute("msg", "添加成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //重定向到列表页面
        return "redirect:/adminpioneer/admin/entrepreneurList";
    }

    //来到修改页面
    @GetMapping("/entrepreneur/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Entrepreneur entrepreneurById = service.getEntrepreneurById(id);
        model.addAttribute("entrepreneur", entrepreneurById);
        return "addEntrepreneur";
    }

    //提交修改
    @PutMapping("/entrepreneur")
    public String updateEntrepreneur(@RequestParam("file") MultipartFile multipartFile,
                                     @RequestParam("id") Integer id,
                                     @RequestParam("name") String name,
                                     @RequestParam("url") String url,
                                     @RequestParam("introduction") String introduction,
                                     @RequestParam("content") String content,
                                     @RequestParam("text") String text,
                                     RedirectAttributes redirectAttributes) {
        try {
            Entrepreneur entrepreneur;
            if (!multipartFile.isEmpty()) {
                //得到和存储文件
                byte[] bytes = multipartFile.getBytes();
                Path path = Paths.get(filePath + multipartFile.getOriginalFilename());
                Files.write(path, bytes);
                entrepreneur = new Entrepreneur(id, name, introduction, "/images/" + multipartFile.getOriginalFilename(), content, text);
            } else {
                entrepreneur = new Entrepreneur(id, name, introduction, url, content, text);
            }
            int i = service.updateEntrepreneur(entrepreneur);
            if (i > 0) {
                redirectAttributes.addFlashAttribute("msg", "修改成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //重定向到列表页面
        return "redirect:/adminpioneer/admin/entrepreneurList";
    }

    //删除一个团队资料
    @PostMapping(value = "/entrepreneurList/deleteById", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> deleteById(@RequestBody JSONObject jsonObject) {
        int id = jsonObject.getIntValue("id");
        Map<String, Object> map = new HashMap<>();
        int result = service.deleteById(id);
        if (result > 0) {
            map.put("msg", "成功删除资料");
        } else {
            map.put("msg", "删除资料失败");
        }
        return map;
    }

    //批量删除团队
    @PostMapping(value = "/entrepreneurList/deleteByIds", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> deleteByIds(@RequestBody JSONObject jsonParam) {
        String ids = jsonParam.getString("ids");
        Map<String, Object> map = new HashMap<>();
        int byIds = service.deleteByIds(ids);
        if (byIds > 0) {
            map.put("msg", "批量删除资料成功！");
        } else {
            map.put("msg", "批量删除资料失败！");
        }
        return map;
    }
}
