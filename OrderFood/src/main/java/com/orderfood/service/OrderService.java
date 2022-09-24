package com.orderfood.service;

import com.orderfood.config.MessagingConfig;
import com.orderfood.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final RabbitTemplate rabbitTemplate;

    public void placeOrder(Order order) {
        order.setId(UUID.randomUUID());
        order.setCreatedAt(new Date(System.currentTimeMillis()));
        rabbitTemplate.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, order);
    }
}
