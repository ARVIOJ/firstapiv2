package com.trainibit.first_api.mapper.Impl;

import com.trainibit.first_api.entity.FederalState;
import com.trainibit.first_api.mapper.FederalStateMapper;
import com.trainibit.first_api.response.FederalStateResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FederalStateMapperImpl implements FederalStateMapper {

    @Override
    public FederalStateResponse entityToResponseFederalResponse(FederalState federalState) {
        FederalStateResponse federalStateResponse = new FederalStateResponse();

        federalStateResponse.setUuid(federalState.getUuid());
        federalStateResponse.setName(federalState.getName());

        return federalStateResponse;
    }

    @Override
    public List<FederalStateResponse> entityToResponseListFederalResponse(List<FederalState> federalStatesList) {
        List<FederalStateResponse> federalStateResponseList = new ArrayList<>();

        federalStatesList.forEach(federalState -> federalStateResponseList.add(entityToResponseListFederalResponse(federalState)));

        return federalStateResponseList;
    }
}
