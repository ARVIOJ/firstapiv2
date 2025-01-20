package com.trainibit.first_api.mapper.Impl;

import com.trainibit.first_api.entity.FederalState;
import com.trainibit.first_api.mapper.FederalStateMapper;
import com.trainibit.first_api.response.FederaSatateResponse;
import com.trainibit.first_api.response.RoleResponse;

import java.util.ArrayList;
import java.util.List;

public class FederalStateMapperImpl implements FederalStateMapper {

    @Override
    public FederaSatateResponse entityToResponseFederalResponse(FederalState federalState) {
        FederaSatateResponse federaSatateResponse = new FederaSatateResponse();

        federaSatateResponse.setUuid(federalState.getUuid());
        federaSatateResponse.setName(federalState.getName());

        return federaSatateResponse;
    }

    @Override
    public List<FederaSatateResponse> entityToResponseListFederalResponse(List<FederalState> federalStatesList) {
        List<FederaSatateResponse> federalSatateResponseList = new ArrayList<>();

        //federalStatesList.forEach(federalState -> federalSatateResponseList.add(entityToResponseListFederalResponse(federalState)));

        return federalSatateResponseList;
    }
}
