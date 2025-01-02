package com.example.Library.Management.System.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrower {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long borrower_id;

    @NotNull(message = "Name should not be null")
    private String bname;

    @Email(message = "Email should be valid")
    @Column(unique = true)
    private String email;

    @OneToMany(
            mappedBy = "borrower",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Book> borrowedBooks = new HashSet<>();


}
