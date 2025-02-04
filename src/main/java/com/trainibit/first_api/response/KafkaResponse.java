package com.trainibit.first_api.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class KafkaResponse {
    private UUID uuid;
    private String email;
    private String token;
}

