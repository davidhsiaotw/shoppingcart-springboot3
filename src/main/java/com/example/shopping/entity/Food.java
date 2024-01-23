package com.example.shopping.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@DiscriminatorValue("food")
public class Food extends AbstractProduct {
    public Food(String name, Double price, Integer quantity, String imageUrl, ShoppingCart cart) {
        super(name, price, quantity, imageUrl, cart);
    }
}
