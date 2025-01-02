    package com.example.bookstore.Bookstore.Controller;

    import com.example.bookstore.Bookstore.Entity.Book;
    import com.example.bookstore.Bookstore.Service.BookService;
    import com.example.bookstore.Bookstore.Service.BookServiceImpl;
    import jakarta.validation.Valid;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    public class BookController {

        @Autowired
        private BookService bookService;

        @PostMapping("/books")
        public ResponseEntity<?> saveBook(@Valid @RequestBody Book book) {
            Book savedBook = bookService.saveBooks(book);
            return ResponseEntity.ok(savedBook);
        }


        @GetMapping("/books")
        public List<Book> getAllBooks(){
            return bookService.getAllBooks();
        }

        @PutMapping("/books/{id}")
        public Book updateBook(@PathVariable("id") Long bookid, @RequestBody Book book){
            return bookService.updateBooks(bookid,book);
        }

        @DeleteMapping("/books/{id}")
        public void deleteBook(@PathVariable("id")  Long bookid)    {
             bookService.deleteBooks(bookid);
        }

    }
