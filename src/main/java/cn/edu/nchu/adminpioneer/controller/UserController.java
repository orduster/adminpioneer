package cn.edu.nchu.adminpioneer.controller;

import cn.edu.nchu.adminpioneer.config.WebSecurityConfig;
import cn.edu.nchu.adminpioneer.entity.User;
import cn.edu.nchu.adminpioneer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/adminpioneer/admin")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String account, Model model) {
        return "article";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginVerify(@RequestParam("username") String username,
                              @RequestParam("password") String password, HttpSession session) {
        User user = new User(username, password);

        Boolean verify = service.findByUsernameAndPassword(user);
        if (verify) {
            session.setAttribute(WebSecurityConfig.SESSION_KEY, username);
            return "redirect:/adminpioneer/admin/";
        } else {
            return "redirect:/adminpioneer/admin/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/adminpioneer/admin/login";
    }

    /*来到修改界面*/
    @GetMapping("/user")
    public String toUpdatePage() {
        return "user";
    }

    @PostMapping("/user")
    public String updateUser(@RequestParam("username") String username,
                             @RequestParam("password") String password) {

        User user = new User(username, password);
        int i = service.updateUser(user);
        return "redirect:/adminpioneer/admin/logout";
    }
}
