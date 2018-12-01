package cn.edu.nchu.adminpioneer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件上传
 */
@Controller
@RequestMapping("/adminpioneer/admin")
public class FileUploadController {

    /*文件存储目录*/
    @Value("${file.path}")
    private String filePath;

    //ueditor中处理图片上传
    @RequestMapping("/uploadImages")
    @ResponseBody
    public Map<String, Object> uploadImages(@RequestParam(value = "editormd-image-file", required = false) MultipartFile file, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String fileName = file.getOriginalFilename();
        //保存
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(filePath + fileName);
            Files.write(path, bytes);
            resultMap.put("success", 1);
            resultMap.put("message", "上传成功！");
            resultMap.put("url", "../images/" + fileName);
        } catch (Exception e) {
            resultMap.put("success", 0);
            resultMap.put("message", "上传失败！");
            e.printStackTrace();
        }
        System.out.println(resultMap.get("success"));
        return resultMap;
    }

}
