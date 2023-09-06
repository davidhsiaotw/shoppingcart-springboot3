package com.example.shopping.service;

import com.example.shopping.data.FakeData;
import com.example.shopping.repository.FoodRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class FoodServiceImpl implements FoodService{
    private FoodRepository repository;

    @Override
    public void createAll() {
        repository.saveAll(FakeData.getInstance().metaFoods);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
