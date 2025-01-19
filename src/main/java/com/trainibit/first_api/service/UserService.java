package com.trainibit.first_api.service;

import com.trainibit.first_api.entity.User;
import com.trainibit.first_api.request.UserRequest;
import com.trainibit.first_api.response.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserResponse> findAll();

    UserResponse findByUuid(UUID uuid);

    //post
    UserResponse saveUser(UserRequest userRequest);

    //eliminar
    void deleteUser(UUID uuid);

    //actualizar
    UserResponse updateUser(UUID uuid,UserRequest userRequest);
}