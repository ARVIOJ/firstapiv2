package com.trainibit.first_api.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trainibit.first_api.entity.FederalState;
import com.trainibit.first_api.entity.Role;
import com.trainibit.first_api.entity.RolesByUser;
import com.trainibit.first_api.entity.User;
import com.trainibit.first_api.mapper.UserMapper;
import com.trainibit.first_api.repository.FederalStateRepository;
import com.trainibit.first_api.repository.RoleRepository;
import com.trainibit.first_api.repository.UserRepository;
import com.trainibit.first_api.request.RolesRequest;
import com.trainibit.first_api.request.UserRequest;
import com.trainibit.first_api.response.KafkaResponse;
import com.trainibit.first_api.response.UserResponse;
import com.trainibit.first_api.service.KafkaMessageProducer;
import com.trainibit.first_api.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessageProducerImpl implements KafkaMessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final String topicName = "USUARIO_REGISTRADO";

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void sendMessage(KafkaResponse kafkaResponse) {
        try{
            CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, kafkaResponse.getUuid().toString(), objectMapper.writeValueAsString(kafkaResponse));
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Sent message=[" + kafkaResponse.getEmail() +
                            "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send message=[" +
                            kafkaResponse.getEmail() + "] due to : " + ex.getMessage());
                }
            });
        }catch (Exception e){
            throw new RuntimeException("Error converting kafkaResponse to JSON", e);
        }
    }
}
