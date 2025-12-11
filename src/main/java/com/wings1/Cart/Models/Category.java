package com.wings1.Cart.Models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String categoryName;
}
