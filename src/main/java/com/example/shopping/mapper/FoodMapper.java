package com.example.shopping.mapper;

import com.example.shopping.dto.FoodDto;
import com.example.shopping.entity.Food;

public class FoodMapper {

    public static FoodDto mapToFoodDto(Food food) {
        return new FoodDto(food.getId(), food.getName(), food.getPrice(), food.getImageUrl());
    }

    public static Food mapToFood(FoodDto foodDto) {
        return new Food(foodDto.getId(), foodDto.getImageUrl(), foodDto.getPrice(), foodDto.getImageUrl());
    }
}
