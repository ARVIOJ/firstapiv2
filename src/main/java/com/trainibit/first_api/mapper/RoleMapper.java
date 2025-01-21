package com.trainibit.first_api.mapper;

import com.trainibit.first_api.entity.Role;
import com.trainibit.first_api.response.RoleResponse;

import java.util.List;
import java.util.UUID;

public interface RoleMapper {
    RoleResponse entityToResponseRole(Role role);
}
