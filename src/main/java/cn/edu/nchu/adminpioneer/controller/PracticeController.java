package cn.edu.nchu.adminpioneer.controller;

import cn.edu.nchu.adminpioneer.entity.Practice;
import cn.edu.nchu.adminpioneer.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminpioneer/admin")
public class PracticeController {

    @Autowired
    private PracticeService practiceService;

    @GetMapping("/practice")
    public String practice(Model model) {
        Practice practice = practiceService.getPractice();
        model.addAttribute("practice", practice);
        return "practice";
    }

    @PostMapping("/practice")
    public String addPractice(Practice practice) {
        practiceService.addPractice(practice);
        return "redirect:/adminpioneer/admin/practice";
    }

    @PutMapping("/practice")
    public String updatePractice(Practice practice) {
        practiceService.updatePractice(practice);
        return "redirect:/adminpioneer/admin/practice";
    }
}
