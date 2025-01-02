package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.Entity.Book;
import com.example.Library.Management.System.Exception.ResourceNotFoundException;
import com.example.Library.Management.System.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book savebooks(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> fetchBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book fetchBookById(Long bookid) {
        Book book =  bookRepository.findById(bookid).get();
        return book;
    }

    @Override
    public Book updateBook(Long id, Book book) {

        Optional<Book> updateBook = bookRepository.findById(id);

        if(updateBook.isPresent()){
            Book existingBook = updateBook.get();
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setPrice(book.getPrice());
            existingBook.setPublishedDate(book.getPublishedDate());
            return bookRepository.save(existingBook);
        }
        else {
            throw new ResourceNotFoundException("Book not found with id: " + id);
        }
    }

    @Override
    public String deletebook(Long bookid) {
        Optional<Book> deleteBook = bookRepository.findById(bookid);

        if(deleteBook.isPresent()){
             bookRepository.delete(deleteBook.get());
            return "Book with ID " + bookid + " deleted successfully.";
        }
        else {
            throw new ResourceNotFoundException("Book not found with id: " + bookid);
        }
    }


}
