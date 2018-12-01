package cn.edu.nchu.adminpioneer.controller;

import cn.edu.nchu.adminpioneer.entity.IndexImages;
import cn.edu.nchu.adminpioneer.service.IndexImagesService;
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
public class IndexImagesController {

    @Autowired
    private IndexImagesService service;

    /*存储文件目录*/
    @Value("${file.path}")
    private String filePath;

    //显示所有轮播图片信息
    @PostMapping(value = "/imageList", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> showImageList(@RequestBody JSONObject jsonObject) {
        int pageSize = jsonObject.getIntValue("pageSize");//每页显示数
        int offset = jsonObject.getIntValue("offset");//页码
        Map<String, Object> map = new HashMap<>();
        List<IndexImages> indexImages = service.showIndexImages(pageSize, offset);
        int count = service.count();
        map.put("total", count);
        map.put("rows", indexImages);
        return map;
    }

    //来到图片添加页面
    @GetMapping("/image")
    public String toAddPage() {
        return "addImage";
    }

    //添加图片
    @PostMapping(value = "/image")
    public String addArticle(@RequestParam("file") MultipartFile multipartFile,
                             @RequestParam("description") String description,
                             RedirectAttributes redirectAttributes) {
        if (multipartFile.isEmpty()) {
            redirectAttributes.addFlashAttribute("msg", "上传失败，文件为空！");
            return "redirect:/adminpioneer/admin/articleList";
        }
        try {
            //得到和存储文件
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(filePath + multipartFile.getOriginalFilename());
            Files.write(path, bytes);
            IndexImages images = new IndexImages(description, "/images/" + multipartFile.getOriginalFilename());
            int indexImages = service.addIndexImages(images);
            if (indexImages > 0) {
                redirectAttributes.addFlashAttribute("msg", "添加成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //重定向到列表页面
        return "redirect:/adminpioneer/admin/articleList";
    }

    //来到修改页面
    @GetMapping("/image/{id}")
    public String toEditPage(@PathVariable("id") int id, Model model) {
        IndexImages indexImages = service.getIndexImages(id);
        model.addAttribute("indexImages", indexImages);
        return "addImage";
    }

    //提交修改
    @PutMapping("/image")
    public String updateArticle(@RequestParam("file") MultipartFile multipartFile,
                                @RequestParam("id") Integer id,
                                @RequestParam("description") String description,
                                @RequestParam("url") String url,
                                RedirectAttributes redirectAttributes) {
        try {
            IndexImages images;
            if (!multipartFile.isEmpty()) {
                //得到和存储文件
                byte[] bytes = multipartFile.getBytes();
                Path path = Paths.get(filePath + multipartFile.getOriginalFilename());
                Files.write(path, bytes);
                images = new IndexImages(id, description, "/images/" + multipartFile.getOriginalFilename());
            } else {
                images = new IndexImages(id, description, url);
            }
            int i = service.updateIndexImages(images);
            if (i > 0) {
                redirectAttributes.addFlashAttribute("msg", "修改成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/adminpioneer/admin/articleList";
    }

    //删除图片
    @PostMapping(value = "/imageList/deleteById", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> deleteById(@RequestBody JSONObject jsonObject) {
        int id = jsonObject.getIntValue("id");
        Map<String, Object> map = new HashMap<>();
        int byId = service.deleteById(id);
        if (byId > 0) {
            map.put("msg", "成功删除图片");
        } else {
            map.put("msg", "删除图片失败");
        }
        return map;
    }
}
