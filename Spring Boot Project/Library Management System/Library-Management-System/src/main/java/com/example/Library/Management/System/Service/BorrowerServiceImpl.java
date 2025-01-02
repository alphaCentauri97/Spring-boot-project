package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.Entity.Book;
import com.example.Library.Management.System.Entity.BookStatus;
import com.example.Library.Management.System.Entity.Borrower;
import com.example.Library.Management.System.Exception.ResourceNotFoundException;
import com.example.Library.Management.System.Repository.BookRepository;
import com.example.Library.Management.System.Repository.BorrowerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowerServiceImpl implements BorrowerService{


    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowerRepository borrowerRepository;

    @Transactional
    public String borrowBook(Long bookId, Long borrowerId) {

        Book book = bookRepository.findById(bookId).orElseThrow(()-> new ResourceNotFoundException("Book not found with ID: " + bookId));

        if (book.getStatus() == BookStatus.BORROWED) {
            throw new IllegalStateException("Book is already borrowed.");
        }

        Borrower borrower = borrowerRepository.findById(borrowerId).orElseThrow(() ->new ResourceNotFoundException("Borrower not found with ID: " + borrowerId));
        if (borrower.getBorrowedBooks().size() >= 2) {
            throw new IllegalStateException("Borrower has already borrowed the maximum allowed books.");
        }

        // Update the book's status and associate it with the borrower
        book.setStatus(BookStatus.BORROWED);
        book.setBorrower(borrower);

        // Save the updated book
        bookRepository.save(book);

        return "Book borrowed successfully!";
    }

    @Override
    public String returnBook(Long bookId) {
        return "";
    }
}
