package com.trainibit.first_api.request;

import com.trainibit.first_api.entity.FederalState;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @Size(max = 64)
    private String firstName;

    @NotNull
    @Size(max = 64)
    private String lastName;

    @NotNull

    @Pattern(
            regexp = "^(\\d{4})\\-(\\d{2})\\-(\\d{2})$",
            message = "Formato de fecha incorrecto, debe ser yy/mm/dd"
    )
    private String birthdate;

    @NotNull
    @Email
    @Size(max = 128)
    private String email;

    private UUID federalState;

    private List<RolesRequest> roles;

}