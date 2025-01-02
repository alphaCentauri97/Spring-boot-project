package com.example.Relation.Mapping.Repository;

import com.example.Relation.Mapping.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library,Long> {
}
