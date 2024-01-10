package com.jakub_szalkowski.spring_project;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jakub_szalkowski.spring_project.controllers.data.BooksRepository;
import com.jakub_szalkowski.spring_project.controllers.models.Book;

import java.util.Optional;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/books/api")
public class BooksControllerAPI {
    private BooksRepository booksData;

    public BooksControllerAPI(BooksRepository repo) {
        super();
        booksData = repo;
    }

    @GetMapping(value = "/list")
    public List<Book> books() {
        List<Book> allBooks = booksData.findAll();
        return allBooks;
    }
    @PostMapping(value = "/save")
    public Book save(@RequestBody Book book) {
        if (book != null) {
            booksData.save(book);
        }
        return book;
    }
    @GetMapping(value = "/edit/{id}")
    public Book editBook(@PathVariable long id) {
        Optional<Book> book = booksData.findById(id);

        if(book != null)
        {
            return book.get();
        }
        else {
            return books().get(0);
        }
    }
    @DeleteMapping(value = "/delete/{id}")
    public Boolean deleteBook(@PathVariable long id) 
    {
        Optional<Book> book = booksData.findById(id);
        
        if(book != null) 
        {
            booksData.delete(book.get());
            return true;
        }
        return false;

    }
    
    
}
