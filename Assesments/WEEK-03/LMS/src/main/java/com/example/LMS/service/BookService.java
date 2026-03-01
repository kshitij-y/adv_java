package com.example.LMS.service;


import com.example.LMS.exception.BookNotFoundException;
import com.example.LMS.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
    }

    public List<Book> getAllBooks(){
        return books;
    }

    public Book getBookById(long id){
        return books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book not found with this id"));
    }

    public void deleteBookById(long id) {
        Book book = getBookById(id);
        books.remove(book);
    }
}
