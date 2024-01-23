package com.example.shopping.data;

import com.example.shopping.entity.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FakeData {
    private static FakeData singleInstance = null;

    private FakeData() {
        Random random = new Random();

        for (int i = 1; i <= 100; i++) {
            int index = random.nextInt(0, NAMES.size());
            String name = NAMES.get(index);
            double price = Math.round(random.nextDouble(0.01, 100.00) * 100.0) / 100.0;
            String imageUrl = IMAGE_RESOURCES.get(index);
            metaFoods.add(new Food(i, name, price, imageUrl));
        }
    }

    private static final List<String> NAMES = List.of(
            "Bread", "Egg", "Dessert", "Meat", "Pasta", "Soup", "Seafood"
    );
    private static final List<String> IMAGE_RESOURCES = List.of(
            "https://cdn.pixabay.com/photo/2017/10/18/17/08/bread-2864793_1280.jpg",
            "https://cdn.pixabay.com/photo/2019/11/21/14/46/bread-4642686_1280.jpg",
            "https://cdn.pixabay.com/photo/2017/05/23/04/13/strawberry-dessert-2336121_1280.jpg",
            "https://cdn.pixabay.com/photo/2018/02/08/15/02/meat-3139641_1280.jpg",
            "https://cdn.pixabay.com/photo/2018/07/18/19/12/pasta-3547078_1280.jpg",
            "https://cdn.pixabay.com/photo/2017/01/24/20/30/soup-2006317_1280.jpg",
            "https://cdn.pixabay.com/photo/2016/07/21/09/57/snow-crab-1532115_1280.jpg");

    public final List<Food> metaFoods = new ArrayList<>();

    public static synchronized FakeData getInstance() {
        if (singleInstance == null)
            singleInstance = new FakeData();
        return singleInstance;
    }
}