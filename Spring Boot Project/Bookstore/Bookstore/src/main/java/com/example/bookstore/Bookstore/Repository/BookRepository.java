package com.example.bookstore.Bookstore.Repository;

import com.example.bookstore.Bookstore.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {

}
