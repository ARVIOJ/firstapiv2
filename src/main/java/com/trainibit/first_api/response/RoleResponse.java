package com.trainibit.first_api.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RoleResponse {
    String name;
    UUID uuid;

}
