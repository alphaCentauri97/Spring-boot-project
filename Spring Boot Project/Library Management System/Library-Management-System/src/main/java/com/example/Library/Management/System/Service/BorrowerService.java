package com.example.Library.Management.System.Service;

public interface BorrowerService {
    String borrowBook(Long bookId, Long borrowerId);

    String returnBook(Long bookId);
}
