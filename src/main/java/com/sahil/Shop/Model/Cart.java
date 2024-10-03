package com.sahil.Shop.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_items")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String image;
    private Long productId;
    private String productName;
    private Double price;
    private Integer quantity;

    public Cart() {}

    public Cart(String userId,String image, Long productId, String productName, Double price, Integer quantity) {
        this.userId = userId;
        this.image=image;
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters omitted for brevity
}


