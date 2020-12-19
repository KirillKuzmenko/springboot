package jm.kuzmenko.springboot.controllers;

import jm.kuzmenko.springboot.models.User;
import jm.kuzmenko.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/users"}, method = RequestMethod.GET)
    public String listUsers(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        User user = userService.findUserBuyUsername(login);
        model.addAttribute("login", user);
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.listUser());
        return "admin";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addOrUpdateUser(@ModelAttribute("user") User user) {
        if (user.getId() == null) {
            this.userService.addUser(user);
        } else {
            this.userService.updateUser(user);
        }
        return "redirect:/admin/users";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        this.userService.removeUser(id);
        return "redirect:/admin/users";
    }
}
