package com.trainibit.first_api.service.impl;

import com.trainibit.first_api.entity.FederalState;
import com.trainibit.first_api.mapper.FederalStateMapper;
import com.trainibit.first_api.repository.FederalStateRepository;
import com.trainibit.first_api.response.FederalStateResponse;
import com.trainibit.first_api.service.FederalStateService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class FederalStateServiceImpl implements FederalStateService {
    @Autowired
    private FederalStateRepository federalStateRepository;

    @Override
    public FederalState findByUuid(UUID uuid) {
        log.info("Buscando estado federal por uuid: " + uuid);
        return federalStateRepository.findByUuid(uuid);
    }

//    @Override
//    public List<FederalStateResponse> findAll() {
//        log.info("Buscando todos los estados federales");
//        //return federalStateRepository.findAll();
//    }

}
