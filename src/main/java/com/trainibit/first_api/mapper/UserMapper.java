package com.trainibit.first_api.mapper;

import com.trainibit.first_api.entity.User;
import com.trainibit.first_api.request.UserRequest;
import com.trainibit.first_api.response.UserResponse;

import java.util.List;

public interface UserMapper {

    UserResponse entityToResponse(User user);
    // ESTO ES NUEVO
    List<UserResponse> entityToResponseList(List<User> users);

    //post
    User requestToEntity(UserRequest userRequest);

}
