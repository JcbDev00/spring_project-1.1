package com.jakub_szalkowski.spring_project;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jakub_szalkowski.spring_project.controllers.data.ExpensesRepository;
import com.jakub_szalkowski.spring_project.controllers.models.Expense;

import java.util.Optional;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/expenses/api")
public class ExpensesControllerAPI {
    private ExpensesRepository expensesData;

    public ExpensesControllerAPI(ExpensesRepository repo) {
        super();
        expensesData = repo;
    }

    @GetMapping(value = "/list")
    public List<Expense> expenses() {
        List<Expense> allExpenses = expensesData.findAll();
        return allExpenses;
    }
    @PostMapping(value = "/save")
    public Expense save(@RequestBody Expense expense) {
        if (expense != null) {
            expensesData.save(expense);
        }
        return expense;
    }
    @GetMapping(value = "/edit/{id}")
    public Expense editExpense(@PathVariable long id) {
        Optional<Expense> expense = expensesData.findById(id);

        if(expense != null)
        {
            return expense.get();
        }
        else {
            return expenses().get(0);
        }
    }
    @PutMapping("/update/{id}")
    public Expense edit(@PathVariable long id, @RequestBody Expense newExpense) {
       
        return expensesData.findById(id).map(exp -> {
            exp.setTitle(newExpense.getTitle());
            exp.setAmount(newExpense.getAmount());

            return expensesData.save(exp);
        }).orElseGet(() -> {
            newExpense.setId(id);
            return expensesData.save(newExpense);
        });

    }
    @DeleteMapping(value = "/delete/{id}")
    public Boolean deleteExpense(@PathVariable long id) 
    {
        Optional<Expense> expense = expensesData.findById(id);
        
        if(expense != null) 
        {
            expensesData.delete(expense.get());
            return true;
        }
        return false;

    }
    
    
}
