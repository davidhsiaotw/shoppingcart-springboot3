package com.example.shopping.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @Type(value = Food.class, name = "food"),
        @Type(value = Game.class, name = "game")
})
@NoArgsConstructor
@Inheritance
@DiscriminatorColumn
@Entity
@Table(name = "product")
public abstract class AbstractProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected String id;

    protected String name;

    protected Double price;

    protected Integer quantity;

    protected String imageUrl;

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    @JsonBackReference
    protected ShoppingCart cart;

    protected AbstractProduct(String id, String name, Double price, Integer quantity, String imageUrl, ShoppingCart cart) {
        if (id == null)
            this.id = UUID.randomUUID().toString();
        else this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.cart = cart;
    }
}
