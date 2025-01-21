package com.trainibit.first_api.mapper;

import com.trainibit.first_api.entity.RolesByUser;
import com.trainibit.first_api.response.RolesByUserResponse;

public interface RolesByUserMapper {

    RolesByUserResponse entityToResponse(RolesByUser rolesByUser);

}
