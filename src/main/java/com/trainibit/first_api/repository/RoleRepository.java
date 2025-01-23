package com.trainibit.first_api.repository;

import com.trainibit.first_api.entity.Role;
import com.trainibit.first_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByUuid(UUID uuid);
}
