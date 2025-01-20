package com.trainibit.first_api.mapper;

import com.trainibit.first_api.entity.Role;
import com.trainibit.first_api.response.RoleResponse;

import java.util.List;

public interface RoleMapper {
    RoleResponse entityToResponseRole(Role role);
    List<RoleResponse> entityToResponseListRole(List<Role> roles);
}
