package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.Entity.Book;

import java.util.List;

public interface BookService {
    Book savebooks(Book book);

    List<Book> fetchBooks();

    Book fetchBookById(Long bookid);

    Book updateBook(Long id, Book book);

    String deletebook(Long bookid);
}
