//package com.wings1.Cart.Models;
//
//import jakarta.persistence.*;
//
//@Entity
//public class CartProduct {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer cpId;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn( name= "CART_ID", referencedColumnName = "CART_ID")
//    private Cart cart;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn( name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
//    private Product product;
//    private Integer quantity;
//}
