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
@DiscriminatorValue("game")
public class Game extends AbstractProduct {
    public Game(String name, Double price, Integer quantity, String imageUrl, ShoppingCart cart) {
        super(null, name, price, quantity, imageUrl, cart);
    }
}
