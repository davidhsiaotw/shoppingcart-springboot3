package com.example.shopping.service;

import com.example.shopping.data.FakeData;
import com.example.shopping.entity.AbstractProduct;
import com.example.shopping.entity.ShoppingCart;
import com.example.shopping.repository.ProductRepository;
import com.example.shopping.repository.ShoppingCartRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private ProductRepository productRepository;

    /**
     * Create fake data of shopping carts, only if table is empty.
     */
    @Override
    public void createFake() {
        if (shoppingCartRepository.count() == 0)
            shoppingCartRepository.saveAll(FakeData.getInstance().shoppingCarts);
    }

    /**
     * Create a shopping cart with generated UUID.
     *
     * @return generated UUID
     */
    @Override
    public String create() {
        String uuid = UUID.randomUUID().toString();
        ShoppingCart cart = new ShoppingCart(uuid);
        shoppingCartRepository.save(cart);
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
        Optional<ShoppingCart> opt = shoppingCartRepository.findById(id);
        return opt.orElse(null);
    }

    /**
     * Update a shopping cart
     *
     * @param cart a shopping cart with new information
     */
    @Override
    public void update(ShoppingCart cart) {
        cart.getProducts().forEach(product -> {
            if (product.getId() == null) product.setId(UUID.randomUUID().toString());
        });

        Optional<ShoppingCart> opt = shoppingCartRepository.findById(cart.getId());
        if (opt.isPresent()) {
            Map<String, AbstractProduct> databaseProducts = opt.get().getProducts().stream().collect(Collectors.toMap(AbstractProduct::getId, product -> product));
            Map<String, AbstractProduct> inputProducts = cart.getProducts().stream().collect(Collectors.toMap(AbstractProduct::getId, product -> product));
            // find products that is present in database but not in input
            List<AbstractProduct> removingProducts = databaseProducts.entrySet().stream()
                    .filter(entry -> !inputProducts.containsKey(entry.getKey()))
                    .map(Map.Entry::getValue).toList();
            removingProducts.forEach(p -> p.setCart(null));
            productRepository.deleteAll(removingProducts);

            shoppingCartRepository.save(cart);
        }
    }
}
