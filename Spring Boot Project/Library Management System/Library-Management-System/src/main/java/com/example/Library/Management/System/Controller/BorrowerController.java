package com.example.Library.Management.System.Controller;

import com.example.Library.Management.System.Service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;
    @PostMapping("/borrow/{bookId}")
    public ResponseEntity<String> borrowBook(
            @PathVariable Long bookId,
            @RequestParam Long borrowerId) {
        String response = borrowerService.borrowBook(bookId, borrowerId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/return/{bookId}")
    public ResponseEntity<String> returnBook(@PathVariable Long bookId) {
        String response = borrowerService.returnBook(bookId);
        return ResponseEntity.ok(response);
    }

}
