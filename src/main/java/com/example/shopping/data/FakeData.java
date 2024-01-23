package com.example.shopping.data;

import com.example.shopping.entity.AbstractProduct;
import com.example.shopping.entity.Food;
import com.example.shopping.entity.Game;
import com.example.shopping.entity.ShoppingCart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class FakeData {
    private static FakeData singleInstance = null;

    private FakeData() {
        // generate 500 shopping carts
        for (int i = 1; i <= 500; i++) {
            ShoppingCart cart = new ShoppingCart(UUID.randomUUID().toString());

            // generate 0~10 products for each shopping cart
            Random random = new Random();
            int numberOfItems = random.nextInt(0, 11);
            List<AbstractProduct> fakeProducts = new ArrayList<>(numberOfItems);
            for (int j = 0; j <= numberOfItems; j++) {
                // choose a kind of product type
                List<String> names = FOOD_NAMES;
                List<String> images = FOOD_IMAGE_RESOURCES;
                int type = random.nextInt(1, 3);
                if (type == 2) {
                    names = GAME_NAMES;
                    images = GAME_IMAGE_RESOURCES;
                }

                // generate two indices for names and image resources
                int nameIndex = random.nextInt(0, names.size());
                int imageIndex = random.nextInt(0, images.size());
                // get name and image url from names and image resources with random indices
                String name = names.get(nameIndex);
                String imageUrl = images.get(imageIndex);
                // generate price and quantity
                double price = Math.round(random.nextDouble(0.01, 100.00) * 100.0) / 100.0;
                int quantity = random.nextInt(1, 7);

                switch (type) {
                    case 1 -> fakeProducts.add(new Food(name, price, quantity, imageUrl, cart));
                    case 2 -> fakeProducts.add(new Game(name, price, quantity, imageUrl, cart));
                }
            }

            cart.setProducts(fakeProducts);
            shoppingCarts.add(cart);
        }
    }

    private static final List<String> FOOD_NAMES = List.of(
            "Bread", "Egg", "Dessert", "Meat", "Pasta", "Soup", "Seafood"
    );
    private static final List<String> GAME_NAMES = List.of(
            "BOARD", "VIDEO", "SPORTS"
    );
    private static final List<String> FOOD_IMAGE_RESOURCES = List.of(
            "https://cdn.pixabay.com/photo/2017/10/18/17/08/bread-2864793_1280.jpg",
            "https://cdn.pixabay.com/photo/2019/11/21/14/46/bread-4642686_1280.jpg",
            "https://cdn.pixabay.com/photo/2017/05/23/04/13/strawberry-dessert-2336121_1280.jpg",
            "https://cdn.pixabay.com/photo/2018/02/08/15/02/meat-3139641_1280.jpg",
            "https://cdn.pixabay.com/photo/2018/07/18/19/12/pasta-3547078_1280.jpg",
            "https://cdn.pixabay.com/photo/2017/01/24/20/30/soup-2006317_1280.jpg",
            "https://cdn.pixabay.com/photo/2016/07/21/09/57/snow-crab-1532115_1280.jpg"
    );
    private static final List<String> GAME_IMAGE_RESOURCES = List.of(
            "https://cdn.pixabay.com/photo/2019/04/12/08/44/pacman-4121590_1280.png",
            "https://cdn.pixabay.com/photo/2016/07/12/11/39/checkmate-1511866_1280.jpg",
            "https://cdn.pixabay.com/photo/2023/05/11/03/34/baseball-7985433_1280.jpg"
    );

    public final List<ShoppingCart> shoppingCarts = new ArrayList<>();

    public static synchronized FakeData getInstance() {
        if (singleInstance == null)
            singleInstance = new FakeData();
        return singleInstance;
    }
}