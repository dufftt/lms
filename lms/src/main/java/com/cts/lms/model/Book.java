package com.cts.lms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    private int id;
    private String author;

    private String title;

    private int publicationyear;

    private int quantity;


}
