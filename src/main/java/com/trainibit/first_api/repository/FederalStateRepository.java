package com.trainibit.first_api.repository;

import com.trainibit.first_api.entity.FederalState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FederalStateRepository extends JpaRepository<FederalState, Long> {
    FederalState findByUuid(UUID uuid);
    List<FederalState> findAll();
}
