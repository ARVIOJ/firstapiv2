package com.trainibit.first_api.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class KafkaRequest {
    private UUID uuid;
    private String email;
    private String token;
}

