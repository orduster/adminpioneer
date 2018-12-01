package cn.edu.nchu.adminpioneer.controller;

import cn.edu.nchu.adminpioneer.entity.College;
import cn.edu.nchu.adminpioneer.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminpioneer/admin")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @GetMapping("/college")
    public String getCollege(Model model) {
        College college = collegeService.getCollege();
        model.addAttribute("college", college);
        return "college";
    }

    @PutMapping("/college")
    public String updateCollege(College college) {
        collegeService.updateCollege(college);
        return "redirect:/adminpioneer/admin/college";
    }

    @PostMapping("/college")
    public String addCollege(College college) {
        collegeService.addCollege(college);
        return "redirect:/adminpioneer/admin/college";
    }
}
