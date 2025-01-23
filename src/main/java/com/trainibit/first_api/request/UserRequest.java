package com.trainibit.first_api.request;

import com.trainibit.first_api.entity.FederalState;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UserRequest {

    @NotNull
    @Size(max=64)
    private String firstName;

    private String lastName;

    private String birthdate;

    private String email;

    private UUID federalState;

    private List<RolesRequest> roles;

}