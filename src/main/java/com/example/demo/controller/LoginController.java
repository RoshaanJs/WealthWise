package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.NewUser;
import com.example.demo.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
    
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Loads login.jsp
    }

    @PostMapping("/loginUser")
    public String loginUser(@RequestParam String email, @RequestParam String password, Model model, HttpSession session) {
        if (loginService.validateUser(email, password)) {
            NewUser user = loginService.getUserByEmail(email);
            session.setAttribute("userEmail", email); // Store email in session
            session.setAttribute("userName", user.getName()); // Store name in session
            return "redirect:/expenses"; // Redirect to expenses page
        } else {
            model.addAttribute("message", "Invalid credentials");
            return "login";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login"; // Redirect to login page
    }
    
}
