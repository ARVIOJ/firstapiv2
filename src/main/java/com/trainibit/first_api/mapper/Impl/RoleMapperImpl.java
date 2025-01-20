package com.trainibit.first_api.mapper.Impl;

import com.trainibit.first_api.entity.Role;
import com.trainibit.first_api.entity.User;
import com.trainibit.first_api.mapper.RoleMapper;
import com.trainibit.first_api.response.RoleResponse;
import com.trainibit.first_api.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleResponse entityToResponseRole(Role role) {

        RoleResponse roleResponse = new RoleResponse();

        roleResponse.setUuid(role.getUuid());
        roleResponse.setName(role.getName());

        return roleResponse;
    }

    @Override
    public List<RoleResponse> entityToResponseListRole(List<Role> roleList) {

        List<RoleResponse> roleResponseList = new ArrayList<>();

        roleList.forEach(role -> roleResponseList.add(entityToResponseRole(role)));

        return roleResponseList;

    }
}