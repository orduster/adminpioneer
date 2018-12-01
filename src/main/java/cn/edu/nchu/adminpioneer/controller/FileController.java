package cn.edu.nchu.adminpioneer.controller;

import cn.edu.nchu.adminpioneer.entity.File;
import cn.edu.nchu.adminpioneer.service.FileService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/adminpioneer/admin")
public class FileController {

    /*存储文件目录*/
    @Value("${file.path}")
    private String filePath;

    @Autowired
    private FileService service;

    /*来到添加页面*/
    @GetMapping("/filesList")
    public String getFileList() {
        return "file";
    }

    /*显示全部文件*/
    @PostMapping(value = "/filesList", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> getAllFiles(@RequestBody JSONObject jsonObject) {
        int pageSize = jsonObject.getIntValue("pageSize");//每页显示数
        int offset = jsonObject.getIntValue("offset");//页码
        Map<String, Object> map = new HashMap<>();
        List<File> fileList = service.getAllFile(pageSize, offset);
        int count = service.count();
        map.put("total", count);
        map.put("rows", fileList);
        return map;
    }

    /*来到添加文件页面*/
    @GetMapping("/file")
    public String toAddPage() {
        return "addFile";
    }

    /*上传文件*/
    @PostMapping("/file")
    public String addFile(@RequestParam("file") MultipartFile file,
                          @RequestParam("name") String name,
                          @RequestParam("sort") String sort,
                          RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("msg", "上传失败，文件为空！");
            return "redirect:/adminpioneer/admin/filesList";
        }
        try {
            //得到和存储文件
            byte[] bytes = file.getBytes();
            Path path = Paths.get(filePath + file.getOriginalFilename());
            Files.write(path, bytes);
            /*创建实体类*/
            File file1 = new File(sort, name, file.getOriginalFilename());
            int addFile = service.addFile(file1);
            if (addFile > 0) {
                redirectAttributes.addFlashAttribute("msg", "文件上传成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/adminpioneer/admin/filesList";
    }

    @GetMapping("/download/{id}")
    @ResponseBody
    public String download(@PathVariable("id") Integer id, HttpServletResponse response) {
        File serviceFile = service.getFile(id);
        Path path = Paths.get(filePath + serviceFile.getUrl());
        String fileName = null;
        try {
            fileName = URLEncoder.encode(serviceFile.getUrl(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("application/force-download");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        OutputStream stream = null;
        try {
            stream = response.getOutputStream();
            Files.copy(path,stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "下载完成";
    }

    /*根据id来删除作品*/
    @PostMapping(value = "/filesList/deleteById", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> deleteFileById(@RequestBody JSONObject jsonObject) {
        int id = jsonObject.getIntValue("id");
        Map<String, Object> map = new HashMap<>();
        int byId = service.deleteFileById(id);
        if (byId > 0) {
            map.put("msg", "");
        } else {
            map.put("msg", "删除作品失败");
        }
        return map;
    }
}
