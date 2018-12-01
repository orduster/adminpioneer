package cn.edu.nchu.adminpioneer.controller;

import cn.edu.nchu.adminpioneer.entity.Team;
import cn.edu.nchu.adminpioneer.service.TeamService;
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
public class TeamController {
    /*存储文件目录*/
    @Value("${file.path}")
    private String filePath;

    @Autowired
    private TeamService teamService;

    //进入团队列表
    @GetMapping("/teamList")
    public String teams() {
        return "team";
    }

    //显示所有团队
    @PostMapping(value = "/teams", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> showTeam(@RequestBody JSONObject jsonObject) {
        int pageSize = jsonObject.getIntValue("pageSize");//每页显示数
        int offset = jsonObject.getIntValue("offset");//页码
        Map<String, Object> map = new HashMap<>();
        List<Team> teams = teamService.showTeam(pageSize, offset);
        int count = teamService.countArticle();
        map.put("total", count);
        map.put("rows", teams);
        return map;
    }

    //来到团队添加页面
    @GetMapping("/team")
    public String toAddPage() {
        return "addTeam";
    }

    //添加团队
    @PostMapping(value = "/team")
    public String addTeam(@RequestParam("file") MultipartFile multipartFile,
                          @RequestParam("name") String teamName,
                          @RequestParam("introduction") String introduction,
                          @RequestParam("content") String content,
                          @RequestParam("text") String text,
                          RedirectAttributes redirectAttributes) {
        if (multipartFile.isEmpty()) {
            redirectAttributes.addFlashAttribute("msg", "上传失败，文件为空！");
            return "redirect:/adminpioneer/admin/teamList";
        }
        try {
            //得到和存储文件
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(filePath + multipartFile.getOriginalFilename());
            Files.write(path, bytes);
            Team team = new Team(teamName, introduction, "/images/" + multipartFile.getOriginalFilename(), content, text);
            int addTeam = teamService.addTeam(team);
            if (addTeam > 0) {
                redirectAttributes.addFlashAttribute("msg", "添加成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //重定向到列表页面
        return "redirect:/adminpioneer/admin/teamList";
    }

    //来到修改页面
    @GetMapping("/team/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Team teamById = teamService.getTeamById(id);
        model.addAttribute("team", teamById);
        return "addTeam";
    }

    //提交修改
    @PutMapping("/team")
    public String updateTeam(@RequestParam("file") MultipartFile multipartFile,
                             @RequestParam("id")Integer id,
                             @RequestParam("name") String teamName,
                             @RequestParam("url") String url,
                             @RequestParam("introduction") String introduction,
                             @RequestParam("content") String content,
                             @RequestParam("text") String text,
                             RedirectAttributes redirectAttributes) {
        try {
            Team team;
            if (!multipartFile.isEmpty()) {
                //得到和存储文件
                byte[] bytes = multipartFile.getBytes();
                Path path = Paths.get(filePath + multipartFile.getOriginalFilename());
                Files.write(path, bytes);
                team = new Team(id,teamName, introduction, "/images/" + multipartFile.getOriginalFilename(), content, text);
            } else {
                team = new Team(id,teamName, introduction, url, content, text);
            }
            int addTeam = teamService.updateTeam(team);
            if (addTeam > 0) {
                redirectAttributes.addFlashAttribute("msg", "修改成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //重定向到列表页面
        return "redirect:/adminpioneer/admin/teamList";
    }

    //删除一个团队资料
    @PostMapping(value = "/teamList/deleteById", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> deleteById(@RequestBody JSONObject jsonObject) {
        int id = jsonObject.getIntValue("id");
        Map<String, Object> map = new HashMap<>();
        int result = teamService.deleteById(id);
        if (result > 0) {
            map.put("msg", "成功删除团队资料");
        } else {
            map.put("msg", "删除团队资料失败");
        }
        return map;
    }

    //批量删除团队
    @PostMapping(value = "/teamList/deleteByIds", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> deleteByIds(@RequestBody JSONObject jsonParam) {
        String ids = jsonParam.getString("ids");
        Map<String, Object> map = new HashMap<>();
        int byIds = teamService.deleteByIds(ids);
        if (byIds > 0) {
            map.put("msg", "批量删除团队资料成功！");
        } else {
            map.put("msg", "批量删除团队资料失败！");
        }
        return map;
    }
}
