package com.orderfood.controller;

import com.orderfood.domain.Order;
import com.orderfood.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody Order order){
        orderService.placeOrder(order);
        return ResponseEntity.ok().body("Order placed successfully at: " + Calendar.getInstance().getTime());
    }
}
