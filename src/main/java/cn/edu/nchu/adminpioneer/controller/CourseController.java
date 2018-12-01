package cn.edu.nchu.adminpioneer.controller;

import cn.edu.nchu.adminpioneer.entity.Course;
import cn.edu.nchu.adminpioneer.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminpioneer/admin")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/course")
    public String course(Model model) {
        Course course = courseService.getCourse();
        model.addAttribute("course", course);
        return "course";
    }

    @PostMapping("/course")
    public String addCourse(Course course) {
        courseService.addCourse(course);
        return "redirect:/adminpioneer/admin/course";
    }

    @PutMapping("/course")
    public String updateCourse(Course course) {
        courseService.updateCourse(course);
        return "redirect:/adminpioneer/admin/course";
    }
}
