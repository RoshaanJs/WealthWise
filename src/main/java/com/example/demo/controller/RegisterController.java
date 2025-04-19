package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.demo.entity.NewUser;
import com.example.demo.service.RegisterService;

@Controller
public class RegisterController {
    
    @Autowired
    private RegisterService registerService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("newUser", new NewUser());
        return "register";
    }

    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute NewUser user, RedirectAttributes redirectAttributes) {
        // Check if email already exists
        if (registerService.isUserExists(user.getEmail())) {
            redirectAttributes.addFlashAttribute("message", "User already exists!");
            return "redirect:/register";
        }

        // Check password confirmation
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("message", "Passwords do not match!");
            return "redirect:/register";
        }

        // Register user and redirect to login page
        registerService.registerUser(user);
        redirectAttributes.addFlashAttribute("message", "Registration Successful! Please log in.");
        return "redirect:/login";
    }
}
