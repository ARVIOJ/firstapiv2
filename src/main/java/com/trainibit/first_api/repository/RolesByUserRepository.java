package com.trainibit.first_api.repository;

import com.trainibit.first_api.entity.RolesByUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesByUserRepository extends JpaRepository<RolesByUser, Long>{

}
