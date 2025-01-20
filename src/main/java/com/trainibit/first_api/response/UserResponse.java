package com.trainibit.first_api.response;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UserResponse {

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private UUID uuid;
    private String age; // campo calculado, no debe ir en la base de datos este tipo de datos
    private String planet;
// esto es nuevo
    private FederaSatateResponse federalState;
    private List<RoleResponse> roles;
}
