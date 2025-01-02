package com.example.bookstore.Bookstore.Service;

import com.example.bookstore.Bookstore.Entity.Book;
import com.example.bookstore.Bookstore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService {


    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book saveBooks(Book book) {
        System.out.println("Saving book: " + book);
        return bookRepository.save(book);
    }

    @Override
    public Book updateBooks(Long bookid, Book book) {

        Book bookDB = bookRepository.findById(bookid).get();

        if(Objects.nonNull(book.getAuthor()) && !"".equalsIgnoreCase(book.getAuthor())){
            bookDB.setAuthor(book.getAuthor());
        }
        if(Objects.nonNull(book.getTitle()) && !"".equalsIgnoreCase(book.getTitle())){
            bookDB.setTitle(book.getTitle());
        }
        if(Objects.nonNull(book.getPrice()) && !"".equalsIgnoreCase(book.getPrice())){
            bookDB.setPrice(book.getPrice());
        }
        if(book.getPublishedDate() != null){
            bookDB.setPublishedDate(book.getPublishedDate());
        }


        return bookRepository.save(bookDB);
    }

    @Override
    public void deleteBooks(Long bookid) {
        Book bookDB = bookRepository.findById(bookid).get();

          bookRepository.delete(bookDB);
    }
}
