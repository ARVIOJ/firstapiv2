package com.trainibit.first_api.mapper.Impl;

import com.trainibit.first_api.entity.RolesByUser;
import com.trainibit.first_api.mapper.RolesByUserMapper;
import com.trainibit.first_api.response.RolesByUserResponse;
import org.springframework.stereotype.Service;

@Service
public class RolesByUserMapperImpl implements RolesByUserMapper  {

    @Override
    public RolesByUserResponse entityToResponse(RolesByUser rolesByUser) {
        RolesByUserResponse rolesByUserResponse = new RolesByUserResponse();

        rolesByUserResponse.setCreatedDate(rolesByUser.getCreatedDate());
        rolesByUserResponse.setUpdatedDate(rolesByUser.getUpdatedDate());
        rolesByUserResponse.setUuid(rolesByUser.getUuid());

        return rolesByUserResponse;
    }

}
