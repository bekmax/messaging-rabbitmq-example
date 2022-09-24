package com.restaurant.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

    public static final String QUEUE = "order_queue";
    public static final String EXCHANGE = "order_exchange";
    public static final String ROUTING_KEY = "order_routingKey";

    @Bean
    public Queue getQueue() {
        return new Queue(QUEUE);
    }

    @Bean
    public TopicExchange getExchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding bind() {
        return BindingBuilder.bind(getQueue())
                .to(getExchange())
                .with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
