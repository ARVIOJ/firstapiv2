package com.trainibit.first_api.request;

import com.trainibit.first_api.entity.FederalState;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UserRequest {

    private String firstName;
    private String lastName;
    private String birthdate;
    private String email;

    private FederalState federalState;
    private List<UUID> roles;

}