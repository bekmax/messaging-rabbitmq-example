package com.restaurant.controller;

import com.restaurant.entity.Order;
import com.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurant")
public class RestaurantController {
    private final RestaurantService service;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getOrders(){
        return ResponseEntity.ok().body(service.getAllOrders());
    }
}
