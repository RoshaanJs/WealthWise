package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Expense;
import com.example.demo.entity.NewUser;
import com.example.demo.repository.ExpenseRepository;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense addExpense(String description, double amount, String category, NewUser user) {
        Expense expense = new Expense();
        expense.setDescription(description);
        expense.setAmount(amount);
        expense.setCategory(category);
        expense.setUser(user);
        return expenseRepository.save(expense);
    }

    public List<Expense> getExpensesByUser(NewUser user) {
        return expenseRepository.findByUser(user);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
