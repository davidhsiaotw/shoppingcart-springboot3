package com.example.shopping;

import com.example.shopping.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * <a href="https://stackoverflow.com/a/49699087/22598753">reference</a>
 */
@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    private ShoppingCartService service;

    @Override
    public void run(String... args) {
        service.createFake();
    }
}
