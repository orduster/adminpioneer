package cn.edu.nchu.adminpioneer.controller;

import cn.edu.nchu.adminpioneer.entity.Works;
import cn.edu.nchu.adminpioneer.service.WorksService;
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
public class WorksController {

    /*存储文件目录*/
    @Value("${file.path}")
    private String filePath;

    @Autowired
    private WorksService service;

    /*进入文章*/
    @GetMapping("/worksList")
    public String worksList() {
        return "works";
    }

    /*得到双创作品列表*/
    @PostMapping(value = "/worksList", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> getAllWorks(@RequestBody JSONObject jsonObject) {
        int pageSize = jsonObject.getIntValue("pageSize");//每页显示数
        int offset = jsonObject.getIntValue("offset");//页码
        Map<String, Object> map = new HashMap<>();
        List<Works> works = service.getAllWorksLimit(pageSize, offset);
        int count = service.countWorks();
        map.put("total", count);
        map.put("rows", works);
        return map;
    }

    /*来到添加页面*/
    @GetMapping("/works")
    public String toAddPage() {
        return "addWorks";
    }

    /*增加作品*/
    @PostMapping("/works")
    public String addWorks(@RequestParam("file") MultipartFile multipartFile,
                           @RequestParam("name") String name,
                           @RequestParam("member") String member,
                           @RequestParam("incident") String incident,
                           RedirectAttributes redirectAttributes) {
        if (multipartFile.isEmpty()) {
            redirectAttributes.addFlashAttribute("msg", "上传失败，文件为空！");
            return "redirect:/adminpioneer/admin/worksList";
        }
        try {
            //得到和存储文件
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(filePath + multipartFile.getOriginalFilename());
            Files.write(path, bytes);
            Works works = new Works(name, member, incident, "/images/" + multipartFile.getOriginalFilename());
            int addWorks = service.addWorks(works);
            if (addWorks > 0) {
                redirectAttributes.addFlashAttribute("msg", "添加成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/adminpioneer/admin/worksList";
    }

    /*根据id来删除作品*/
    @PostMapping(value = "/worksList/deleteById", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> deleteWorksById(@RequestBody JSONObject jsonObject) {
        int id = jsonObject.getIntValue("id");
        Map<String, Object> map = new HashMap<>();
        int byId = service.deleteWorksById(id);
        if (byId > 0) {
            map.put("msg", "成功删除作品");
        } else {
            map.put("msg", "删除作品失败");
        }
        return map;
    }

    /*根据id批量删除作品*/
    @PostMapping(value = "/worksList/deleteByIds", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> deleteByIds(@RequestBody JSONObject jsonParam) {
        String ids = jsonParam.getString("ids");
        Map<String, Object> map = new HashMap<>();
        int byIds = service.deleteWorksByIds(ids);
        if (byIds > 0) {
            map.put("msg", "批量删除作品成功！");
        } else {
            map.put("msg", "批量删除作品失败！");
        }
        return map;
    }

    /*来到修改界面并显示数据*/
    @GetMapping("/works/{id}")
    public String toUpdatePage(@PathVariable("id") int id, Model model) {
        Works worksById = service.findWorksById(id);
        model.addAttribute("works", worksById);
        return "addWorks";
    }

    /*提交更新*/
    @PutMapping("/works")
    public String updateWorksById(@RequestParam("file") MultipartFile multipartFile,
                                  @RequestParam("id") Integer id,
                                  @RequestParam("name") String name,
                                  @RequestParam("member") String member,
                                  @RequestParam("incident") String incident,
                                  @RequestParam("url") String url,
                                  RedirectAttributes redirectAttributes) {
        try {
            Works works;
            if (!multipartFile.isEmpty()) {
                //得到和存储文件
                byte[] bytes = multipartFile.getBytes();
                Path path = Paths.get(filePath + multipartFile.getOriginalFilename());
                Files.write(path, bytes);
                works = new Works(id, name, member, incident, "/images/" + multipartFile.getOriginalFilename());
            } else {
                works = new Works(id, name, member, incident, url);
            }
            int i = service.updateWorksById(works);
            if (i > 0) {
                redirectAttributes.addFlashAttribute("msg", "修改成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/adminpioneer/admin/worksList";
    }
}
