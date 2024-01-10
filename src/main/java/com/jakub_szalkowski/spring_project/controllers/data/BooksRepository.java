package com.jakub_szalkowski.spring_project.controllers.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jakub_szalkowski.spring_project.controllers.models.Book;

public interface BooksRepository extends JpaRepository<Book, Long> {} 
