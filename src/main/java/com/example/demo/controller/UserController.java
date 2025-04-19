package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.NewUser;
import com.example.demo.service.UserService;

@Controller  // Change from @RestController to @Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index"; // This should map to index.jsp
    }

    @PostMapping("/saveUser")
    public String saveUser(@RequestParam String name, @RequestParam String email) {
        NewUser user = new NewUser();
        user.setName(name);
        user.setEmail(email);
        userService.saveUser(user);
        return "redirect:/users/"; // Redirects to JSP page
    }
}
