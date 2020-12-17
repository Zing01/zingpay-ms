package com.zingpay.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zingpay.dto.*;
import com.zingpay.entity.Transaction;
import com.zingpay.feign.TelenorIntegrationClient;
import com.zingpay.feign.ZongIntegrationClient;
import com.zingpay.service.TransactionService;
import com.zingpay.token.TokenGenerator;
import com.zingpay.util.TransactionStatus;
import feign.FeignException;
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

    @Autowired
    private ZongIntegrationClient zongIntegrationClient;

    @Autowired
    private TelenorIntegrationClient telenorIntegrationClient;

    @Autowired
    private TokenGenerator tokenGenerator;

    @Value("${queue.name}")
    private String queueName;

    @RabbitListener(queues = "${queue.name}")
    public void recievedMessage(Message message) {
        try {
            String jsonString = new String(message.getBody(), StandardCharsets.UTF_8);
            System.out.println("Message Received : ------- " + jsonString);
            TransactionDto transactionDto = transactionService.convertJSONStringToDto(jsonString);
            transactionService.processTransaction(transactionDto);

            if(transactionDto.getServiceProvider().equals("ZONG")) {
                ZongLoadDto zongLoadDto = ZongLoadDto.convertTransactionToDto(transactionDto);
                ZongLoadResponseDto zongLoadResponseDto = new ZongLoadResponseDto();
                try {
                    if (TokenGenerator.token == null) {
                        try {
                            zongLoadResponseDto = zongIntegrationClient.zongLoad(tokenGenerator.getTokenFromAuthService(), zongLoadDto);
                        } catch (JsonProcessingException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        zongLoadResponseDto = zongIntegrationClient.zongLoad(TokenGenerator.token, zongLoadDto);
                    }
                } catch (FeignException.Unauthorized e) {
                    try {
                        zongLoadResponseDto = zongIntegrationClient.zongLoad(tokenGenerator.getTokenFromAuthService(), zongLoadDto);
                    } catch (JsonProcessingException ex) {
                        ex.printStackTrace();
                    }
                }

                if (zongLoadResponseDto.getBossId() != null || !zongLoadResponseDto.getBossId().equals("")) {
                    Transaction transaction = transactionService.getById(transactionDto.getId());
                    transaction.setTransactionStatusId(TransactionStatus.SUCCESS.getId());
                    transactionService.save(transaction);
                } else {
                    Transaction transaction = transactionService.getById(transactionDto.getId());
                    transaction.setTransactionStatusId(TransactionStatus.FAILED.getId());
                    transactionService.save(transaction);
                }
            } else if(transactionDto.getServiceProvider().equals("TELENOR")) {
                TelenorLoadDto telenorLoadDto = TelenorLoadDto.convertTransactionToDto(transactionDto);
                TelenorLoadResponseDto telenorLoadResponseDto = new TelenorLoadResponseDto();

                try {
                    if (TokenGenerator.token == null) {
                        try {
                            telenorLoadResponseDto = telenorIntegrationClient.telenorLoad(tokenGenerator.getTokenFromAuthService(), telenorLoadDto);
                        } catch (JsonProcessingException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        telenorLoadResponseDto = telenorIntegrationClient.telenorLoad(TokenGenerator.token, telenorLoadDto);
                    }
                } catch (FeignException.Unauthorized e) {
                    try {
                        telenorLoadResponseDto = telenorIntegrationClient.telenorLoad(tokenGenerator.getTokenFromAuthService(), telenorLoadDto);
                    } catch (JsonProcessingException ex) {
                        ex.printStackTrace();
                    }
                }

                if(telenorLoadResponseDto != null) {
                    if (telenorLoadResponseDto.getResultMsg() != null || !telenorLoadResponseDto.getResultMsg().equals("")) {
                        Transaction transaction = transactionService.getById(transactionDto.getId());
                        transaction.setTransactionStatusId(TransactionStatus.SUCCESS.getId());
                        transactionService.save(transaction);
                    } else {
                        Transaction transaction = transactionService.getById(transactionDto.getId());
                        transaction.setTransactionStatusId(TransactionStatus.FAILED.getId());
                        transactionService.save(transaction);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }
}
