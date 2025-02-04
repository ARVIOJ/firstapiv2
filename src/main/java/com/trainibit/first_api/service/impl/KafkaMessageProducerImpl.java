package com.trainibit.first_api.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trainibit.first_api.response.KafkaResponse;
import com.trainibit.first_api.service.KafkaMessageProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaMessageProducerImpl implements KafkaMessageProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value("${kafka.topic.name:USUARIO_REGISTRADO}")
    private String topicName;

    @Override
    public void sendMessage(KafkaResponse kafkaResponse) {
        try {
            String message = objectMapper.writeValueAsString(kafkaResponse);
            CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, kafkaResponse.getUuid().toString(), message);

            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    log.info("Sent message=[{}] with offset=[{}]", kafkaResponse.getEmail(), result.getRecordMetadata().offset());
                } else {
                    log.error("Unable to send message=[{}] due to: {}", kafkaResponse.getEmail(), ex.getMessage());
                }
            });
        } catch (Exception e) {
            log.error("Error converting kafkaResponse to JSON", e);
            throw new RuntimeException("Error converting kafkaResponse to JSON", e);
        }
    }
}