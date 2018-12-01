package cn.edu.nchu.adminpioneer.controller;

import cn.edu.nchu.adminpioneer.entity.Structure;
import cn.edu.nchu.adminpioneer.service.StructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 组织结构
 */
@Controller
@RequestMapping("/adminpioneer/admin")
public class StructureController {
    @Autowired
    private StructureService structureService;

    @GetMapping("/structure")
    public String structure(Model model) {
        Structure structure = structureService.getStructure();
        model.addAttribute("structure", structure);
        return "structure";
    }

    @PostMapping("/structure")
    public String addStructure(Structure structure) {
        structureService.addStructure(structure);
        return "redirect:/adminpioneer/admin/structure";
    }

    @PutMapping("/structure")
    public String updateStructure(Structure structure) {
        structureService.updateStructure(structure);
        return "redirect:/adminpioneer/admin/structure";
    }
}
