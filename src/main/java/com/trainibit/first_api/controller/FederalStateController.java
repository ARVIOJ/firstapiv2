package com.trainibit.first_api.controller;

import com.trainibit.first_api.entity.FederalState;
import com.trainibit.first_api.response.FederalStateResponse;
import com.trainibit.first_api.response.UserResponse;
import com.trainibit.first_api.service.FederalStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/federal-state")
public class FederalStateController {

    @Autowired
    private FederalStateService federalStateService;

    //BUSCAR POR UUID
    @GetMapping("/{uuid}")
    @Cacheable(value = "federalState", key = "#uuid")
    public FederalState getById(@PathVariable UUID uuid) {
        return ResponseEntity.ok(federalStateService.findByUuid(uuid)).getBody();
    }

    //get all
    @GetMapping
    public ResponseEntity<List<FederalStateResponse>> getFederalState() {

        return ResponseEntity.ok(federalStateService.findAll());
    }
}
