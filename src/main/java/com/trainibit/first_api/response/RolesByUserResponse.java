package com.trainibit.first_api.response;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class RolesByUserResponse {
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private UUID uuid;
}
