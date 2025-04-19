package com.example.demo.repository;

import com.example.demo.entity.Expense;
import com.example.demo.entity.NewUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUser(NewUser user);
}
