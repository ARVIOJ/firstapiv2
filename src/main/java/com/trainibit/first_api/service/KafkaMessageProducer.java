package com.trainibit.first_api.service;

import com.trainibit.first_api.response.KafkaResponse;

public interface KafkaMessageProducer {

    void sendMessage(KafkaResponse kafkaResponse);

}
