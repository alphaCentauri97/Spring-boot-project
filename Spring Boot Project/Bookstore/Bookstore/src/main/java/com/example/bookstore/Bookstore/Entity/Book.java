    package com.example.bookstore.Bookstore.Entity;

    import com.fasterxml.jackson.annotation.JsonFormat;
    import com.fasterxml.jackson.annotation.JsonProperty;
    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.validation.constraints.NotNull;
    import jakarta.validation.constraints.PastOrPresent;
    import lombok.*;
    import org.springframework.format.annotation.DateTimeFormat;

    import java.util.Date;

    @Entity
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class Book {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long bookid;

        @JsonProperty("title")
        @NotNull(message = "Title can not be Null")
        private String title;

        @JsonProperty("author")
        @NotNull(message = "Author can not be Null")
        private String author;

        @JsonProperty("price")
        @NotNull(message = "Price can not be Null")
        private String price;

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        @PastOrPresent(message = "Published date must be in the past or present")
        private Date publishedDate;
    }
