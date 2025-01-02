    package com.example.Relation.Mapping.entities;

    import com.fasterxml.jackson.annotation.JsonProperty;
    import jakarta.persistence.*;
    import jakarta.validation.constraints.NotBlank;
    import lombok.Data;

    @Entity
    @Data
    public class Passport {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int passport_id;

        @JsonProperty("passportNumber")
        @Column(nullable = false)
        private String passport_Number;

        @OneToOne(mappedBy = "passport",  cascade = CascadeType.ALL)
        private User user;
    }
