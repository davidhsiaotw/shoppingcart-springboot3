package com.example.shopping.controller;

import com.example.shopping.service.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/foods")
public class FoodController {
    private FoodService foodService;

    @GetMapping("create")
    public ResponseEntity<String> createAllFoods() {
        foodService.createAll();
        return new ResponseEntity<>("insert all foods successfully", HttpStatus.CREATED);
    }

    @GetMapping("delete")
    public ResponseEntity<String> deleteAllFoods(){
        foodService.deleteAll();
        return new ResponseEntity<>("delete all foods successfully", HttpStatus.CREATED);
    }
}
