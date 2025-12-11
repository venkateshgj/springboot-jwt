package com.wings1.Cart.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "PRODUCT_ID")
    private Integer productId;
    private String productName;
    private Double price;
    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn( name = "seller_id", referencedColumnName = "USER_ID")
    @JsonIgnore
    private User seller;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="CATEGORY_ID", referencedColumnName = "categoryId")
    private Category category;


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getProductId() {
        return productId;
    }

    public Product(Integer productId, String productName, Double price, User seller) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.seller = seller;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
