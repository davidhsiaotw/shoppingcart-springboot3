package com.example.shopping.service;

import com.example.shopping.data.FakeData;
import com.example.shopping.entity.ShoppingCart;
import com.example.shopping.repository.ShoppingCartRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartRepository repository;

    /**
     * Create fake data of shopping carts, only if table is empty.
     */
    @Override
    public void createFake() {
        if (repository.count() == 0)
            repository.saveAll(FakeData.getInstance().shoppingCarts);
    }

    /**
     * Create a shopping cart with generated UUID.
     *
     * @param cart a shopping cart
     * @return generated UUID
     */
    @Override
    public String create(@NotNull ShoppingCart cart) {
        String uuid = UUID.randomUUID().toString();
        cart.setId(uuid);
        repository.save(cart);
        return uuid;
    }

    /**
     * Find a shopping cart with UUID
     *
     * @param id UUID
     * @return a shopping cart, otherwise null
     */
    @Override
    public ShoppingCart get(String id) {
        Optional<ShoppingCart> opt = repository.findById(id);
        return opt.orElse(null);
    }

    /**
     * Update a shopping cart
     *
     * @param cart a shopping cart with new information
     */
    @Override
    public void update(ShoppingCart cart) {
        repository.save(cart);
    }
}
