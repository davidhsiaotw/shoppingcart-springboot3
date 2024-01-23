package com.example.shopping.service;

import com.example.shopping.entity.ShoppingCart;

public interface ShoppingCartService {
    void createFake();

    String create(ShoppingCart cart);

    ShoppingCart get(String id);

    void update(ShoppingCart cart);
}
