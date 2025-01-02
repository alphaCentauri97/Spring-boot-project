package com.example.Library.Management.System.Controller;

import com.example.Library.Management.System.Entity.Book;
import com.example.Library.Management.System.Exception.ResourceNotFoundException;
import com.example.Library.Management.System.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/books")
    public Book addBooks(@RequestBody Book book){
        return bookService.savebooks(book);
    }

    @GetMapping("/books")
    public List<Book> fetchAllBooks(){
        return bookService.fetchBooks();
    }

    @GetMapping("/books/{id}")
    public Book fetchBooksById(@PathVariable("id") Long bookid){
        return bookService.fetchBookById(bookid);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        try {
            Book updatedBook = bookService.updateBook(id, book);
            return ResponseEntity.ok(updatedBook);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long bookId) {
        try {
           String message = bookService.deletebook(bookId);
            return ResponseEntity.ok(message); // 204 No Content
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500 Internal Server Error
        }
    }
}
