package com.crystalark.bookservice.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String bookName;
    private String author;
    private String description;
    private double mrp;
    private String category;
}