package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Expense;
import com.example.demo.entity.NewUser;
import com.example.demo.service.ExpenseService;
import com.example.demo.service.LoginService;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private LoginService loginService;

    @GetMapping
    public String showExpenses(Model model, HttpSession session) {
        String email = (String) session.getAttribute("userEmail"); // changed from userEmail to email
        System.out.println("ExpenseController - Session email: " + email); // debug log

        if (email == null) {
            return "redirect:/login";
        }

        NewUser user = loginService.getUserByEmail(email);
        if (user == null) {
            return "redirect:/login";
        }

        List<Expense> expenses = expenseService.getExpensesByUser(user);
        double totalAmount = expenses.stream().mapToDouble(Expense::getAmount).sum();

        model.addAttribute("name", user.getName());
        model.addAttribute("expenses", expenses);
        model.addAttribute("totalAmount", totalAmount);

        return "expenses";
    }

    @PostMapping("/add")
    public String addExpense(@RequestParam String description, @RequestParam double amount, @RequestParam String category, HttpSession session) {
        String email = (String) session.getAttribute("userEmail"); // changed from userEmail to email
        System.out.println("AddExpense - Session email: " + email); // debug log

        if (email == null) {
            return "redirect:/login";
        }

        NewUser user = loginService.getUserByEmail(email);
        if (user != null) {
            expenseService.addExpense(description, amount, category, user);
        }
        return "redirect:/expenses";
    }

    @PostMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }

}
