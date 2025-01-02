package com.example.bookstore.Bookstore.Service;

import com.example.bookstore.Bookstore.Entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    public Book saveBooks(Book book);

    Book updateBooks(Long bookid, Book book);

    void deleteBooks(Long bookid);
}
