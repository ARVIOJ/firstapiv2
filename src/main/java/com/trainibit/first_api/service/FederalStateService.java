package com.trainibit.first_api.service;

import com.trainibit.first_api.entity.FederalState;
import com.trainibit.first_api.response.FederalStateResponse;
import com.trainibit.first_api.response.UserResponse;

import java.util.List;
import java.util.UUID;

public interface FederalStateService {
    FederalState findByUuid(UUID uuid);
    List<FederalStateResponse> getAllFederalStates();

    //List<FederalStateResponse> findAll();
}
