package com.example.Relation.Mapping.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;

    @JsonProperty("name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "passport_id",
            referencedColumnName = "passport_id "

    )
    private Passport passport;
}
