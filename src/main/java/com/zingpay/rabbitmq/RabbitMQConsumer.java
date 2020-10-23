package com.zingpay.rabbitmq;

import com.zingpay.service.TransactionService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @author Bilal Hassan on 10/17/2020
 * @project zingpay-ms
 */

@Component
public class RabbitMQConsumer {

    @Autowired
    private TransactionService transactionService;

    @Value("${queue.name}")
    private String queueName;

    @RabbitListener(queues = "${queue.name}")
    public void recievedMessage(Message message) {
        try {
            String jsonString = new String(message.getBody(), StandardCharsets.UTF_8);
            System.out.println("Message Received : ------- " + jsonString);
            transactionService.processTransaction(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }
}
