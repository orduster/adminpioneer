package cn.edu.nchu.adminpioneer.controller;

import cn.edu.nchu.adminpioneer.entity.Introduction;
import cn.edu.nchu.adminpioneer.service.IntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminpioneer/admin")
public class IntroductionController {

    @Autowired
    private IntroductionService service;

    @GetMapping("/introduction")
    public String introduction(Model model) {
        Introduction introduction = service.getIntroduction();
        model.addAttribute("introduction", introduction);
        return "introduction";
    }

    @PostMapping("/introduction")
    public String addIntroduction(Introduction introduction) {
        service.addIntr(introduction);
        return "redirect:/adminpioneer/admin/introduction";
    }

    @PutMapping("/introduction")
    public String updateIntroduction(Introduction introduction) {
        service.updateIntr(introduction);
        return "redirect:/adminpioneer/admin/introduction";
    }
}
