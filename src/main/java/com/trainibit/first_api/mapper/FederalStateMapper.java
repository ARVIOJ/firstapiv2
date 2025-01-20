package com.trainibit.first_api.mapper;

import com.trainibit.first_api.entity.FederalState;
import com.trainibit.first_api.entity.Role;
import com.trainibit.first_api.response.FederaSatateResponse;
import com.trainibit.first_api.response.RoleResponse;

import java.util.List;

public interface FederalStateMapper {
    FederaSatateResponse entityToResponseFederalResponse(FederalState federalState);
    List<FederaSatateResponse> entityToResponseListFederalResponse(List<FederalState> federalStates);
}
