package cn.edu.nchu.adminpioneer.controller;

import cn.edu.nchu.adminpioneer.entity.Contact;
import cn.edu.nchu.adminpioneer.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminpioneer/admin")
public class ContactController {

    @Autowired
    private ContactService contactService;

    //进入文章
    @GetMapping(value = "/contact")
    public String contact(Model model) {
        Contact contact = contactService.getContact();
        model.addAttribute("contact", contact);
        return "contact";
    }

    @PostMapping(value = "/contact")
    public String addContact(Contact contact) {
        contactService.addContact(contact);
        return "redirect:/adminpioneer/admin/contact";
    }

    @PutMapping(value = "/contact")
    public String updateContact(Contact contact) {
        contactService.updateContact(contact);
        return "redirect:/adminpioneer/admin/contact";
    }
}
