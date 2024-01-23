package com.example.shopping.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Data
@NoArgsConstructor
@Inheritance
@DiscriminatorColumn
@Entity
@Table(name = "product")
public abstract class AbstractProduct {
    @Id
    @UuidGenerator
    protected String id;

    protected String name;

    protected Double price;

    protected Integer quantity;

    protected String imageUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cart_id", referencedColumnName = "id")
    protected ShoppingCart cart;

    protected AbstractProduct(String name, Double price, Integer quantity, String imageUrl, ShoppingCart cart) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.cart = cart;
    }
}
