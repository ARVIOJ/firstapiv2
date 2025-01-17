package com.trainibit.first_api.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserRequest {

    private String firstName;
    private String lastName;
    private String birthdate;
    private String email;

}