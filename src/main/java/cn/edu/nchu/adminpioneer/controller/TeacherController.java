package cn.edu.nchu.adminpioneer.controller;

import cn.edu.nchu.adminpioneer.entity.Teacher;
import cn.edu.nchu.adminpioneer.service.TeacherService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/adminpioneer/admin")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /*来到所有导师显示界面*/
    @GetMapping("/teacherList")
    public String teachers() {
        return "teacher";
    }

    /*显示所有导师*/
    @PostMapping(value = "/teachers", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> showTeacher(@RequestBody JSONObject jsonObject) {
        int pageSize = jsonObject.getIntValue("pageSize");//每页显示数
        int offset = jsonObject.getIntValue("offset");//页码
        Map<String, Object> map = new HashMap<>();
        List<Teacher> teachers = teacherService.showTeacher(pageSize, offset);
        int count = teacherService.countTeacher();
        map.put("total", count);
        map.put("rows", teachers);
        return map;
    }

    /*来到导师添加页面*/
    @GetMapping("/teacher")
    public String toAddPage() {
        return "addTeacher";
    }

    /*添加一篇文章*/
    @PostMapping(value = "/teacher")
    public String addTeacher(Teacher teacher) {
        teacherService.addTeacher(teacher);
        //重定向到列表页面
        return "redirect:/adminpioneer/admin/teacherList";
    }

    //来到修改页面
    @GetMapping("/teacher/{id}")
    public String toEditPage(@PathVariable("id") int id, Model model) {
        Teacher teacherById = teacherService.getTeacherById(id);
        model.addAttribute("teacher", teacherById);
        return "addTeacher";
    }

    //提交修改
    @PutMapping("/teacher")
    public String updateTeacher(Teacher teacher) {
        teacherService.updateTeacher(teacher);
        return "redirect:/adminpioneer/admin/teacherList";
    }

    //删除一个导师资料
    @PostMapping(value = "/teacherList/deleteById", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> deleteById(@RequestBody JSONObject jsonObject) {
        int id = jsonObject.getIntValue("id");
        Map<String, Object> map = new HashMap<>();
        int result = teacherService.deleteById(id);
        if (result > 0) {
            map.put("msg", "成功删除导师资料");
        } else {
            map.put("msg", "删除导师资料失败");
        }
        return map;
    }

    //批量删除导师资料
    @PostMapping(value = "/teacherList/deleteByIds", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> deleteByIds(@RequestBody JSONObject jsonParam) {
        String ids = jsonParam.getString("ids");
        Map<String, Object> map = new HashMap<>();
        int result = teacherService.deleteByIds(ids);
        if (result > 0) {
            map.put("msg", "批量成功删除导师资料");
        } else {
            map.put("msg", "批量删除导师资料失败");
        }
        return map;
    }
}
