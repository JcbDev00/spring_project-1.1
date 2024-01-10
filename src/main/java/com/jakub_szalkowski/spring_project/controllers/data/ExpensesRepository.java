package com.jakub_szalkowski.spring_project.controllers.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jakub_szalkowski.spring_project.controllers.models.Expense;

public interface ExpensesRepository extends JpaRepository<Expense, Long> {
    
}
