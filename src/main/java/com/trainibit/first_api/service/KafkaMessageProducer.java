package com.trainibit.first_api.service;

import com.trainibit.first_api.request.KafkaRequest;
import com.trainibit.first_api.request.UserRequest;
import com.trainibit.first_api.response.UserResponse;

public interface KafkaMessageProducer {

    void sendMessage(KafkaRequest kafkaRequest);

}
