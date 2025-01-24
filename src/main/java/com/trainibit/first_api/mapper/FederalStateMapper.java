package com.trainibit.first_api.mapper;

import com.trainibit.first_api.entity.FederalState;
import com.trainibit.first_api.entity.User;
import com.trainibit.first_api.response.FederalStateResponse;
import com.trainibit.first_api.response.UserResponse;

import java.util.List;

public interface FederalStateMapper {
    FederalStateResponse entityToResponseFederalResponse(FederalState federalState);
    List<FederalStateResponse> entityToResponseListFederalResponse(List<FederalState> federalStates);
}
