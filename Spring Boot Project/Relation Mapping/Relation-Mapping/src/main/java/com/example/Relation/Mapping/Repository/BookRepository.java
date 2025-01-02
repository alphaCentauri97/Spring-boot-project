package com.example.Relation.Mapping.Repository;

import com.example.Relation.Mapping.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
