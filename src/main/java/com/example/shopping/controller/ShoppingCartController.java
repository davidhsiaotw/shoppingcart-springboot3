package com.example.shopping.controller;

import com.example.shopping.entity.ShoppingCart;
import com.example.shopping.service.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/carts")
public class ShoppingCartController {
    private ShoppingCartService service;

    /**
     * Create a new shopping cart.
     *
     * @return response with UUID of the shopping cart and http status
     */
    @GetMapping("create")
    public ResponseEntity<String> create() {
        try{
            return new ResponseEntity<>(service.create(), HttpStatus.CREATED);
        }catch (Exception e) {
            System.out.println("ShoppingCartController.create catches exception");
            System.out.println(e.getMessage());
            return  new ResponseEntity<>("create failed", HttpStatus.CREATED);
        }
    }

    /**
     * Get the shopping cart by id.
     *
     * @param id UUID
     * @return response with data of the shopping cart and http status
     */
    @GetMapping("get/{id}")
    public ResponseEntity<ShoppingCart> get(@PathVariable String id) {
        try {
            ShoppingCart cart = service.get(id);
            return new ResponseEntity<>(cart, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("ShoppingCartController.get catches exception");
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Update the shopping cart.
     *
     * @return response body with message and http status
     */
    @PutMapping("update")
    public ResponseEntity<String> update(@RequestBody ShoppingCart cart) {
        try {
            service.update(cart);
            String responseBody = "update the shopping cart:" + cart.getId() + " successfully";
            return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("ShoppingCartController.update catches exception");
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
