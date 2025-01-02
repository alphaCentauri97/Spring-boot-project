package com.example.Relation.Mapping.Controller;

import com.example.Relation.Mapping.Repository.LibraryRepository;
import com.example.Relation.Mapping.entities.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    public LibraryRepository libraryRepository;


    @GetMapping
    public List<Library> getAllLibraries(){
        return libraryRepository.findAll();
    }

    @PostMapping
    public Library createLibrary(@RequestBody Library library) {
        return libraryRepository.save(library);
    }
}
