package com.jakub_szalkowski.spring_project.controllers.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Expense {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String title;
    private double amount;

    public String getTitle() {
        return title;
    }
    public long getId() {
        return id;
    }
    public double getAmount() {
        return amount;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public void setAmount(double amount) 
    {
        this.amount = amount;
    }
}
