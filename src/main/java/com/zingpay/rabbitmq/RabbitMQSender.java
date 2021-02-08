package com.zingpay.rabbitmq;

import com.zingpay.dto.CommissionDto;
import com.zingpay.dto.TransactionCommissionDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * @author Bilal Hassan on 20-Jan-21
 * @project zingpay-ms
 */

@Service
public class RabbitMQSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${direct.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingkey;

    @Autowired
    public RabbitMQSender(RabbitTemplate rabbitTemplate) {
        super();
        this.rabbitTemplate = rabbitTemplate;
    }

    /*public void send(TransactionCommissionDto transactionCommissionDto) {
        rabbitTemplate.convertAndSend(exchange, routingkey, transactionCommissionDto);
        System.out.println("Send msg = " + transactionCommissionDto);
    }*/

    public void send(CommissionDto commissionDto) {
        rabbitTemplate.convertAndSend(exchange, routingkey, commissionDto);
        System.out.println("Send msg = " + commissionDto);
    }
}
