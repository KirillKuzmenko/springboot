package jm.kuzmenko.springboot.controllers;

import jm.kuzmenko.springboot.models.User;
import jm.kuzmenko.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage() {
        return "index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        User user = userService.findUserBuyUsername(login);
        model.addAttribute("user", user);
        return "user";
    }
}
