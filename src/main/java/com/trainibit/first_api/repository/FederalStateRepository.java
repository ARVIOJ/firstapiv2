package com.trainibit.first_api.repository;

import com.trainibit.first_api.entity.FederalState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FederalStateRepository extends JpaRepository<FederalState, UUID> {
    FederalState findByUuid(UUID uuid);
}
