package com.trainibit.first_api.service.impl;

import com.trainibit.first_api.entity.User;
import com.trainibit.first_api.mapper.UserMapper;
import com.trainibit.first_api.repository.UserRepository;
import com.trainibit.first_api.response.UserResponse;
import com.trainibit.first_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserResponse> findAll() {
        return userMapper.entityToResponseList(userRepository.findAll());
    }


    @Override
    public UserResponse findByUuid(UUID uuid) {
        User userOptional = userRepository.findByUuid(uuid);
        // Manejar el caso en que el usuario no se encuentre
        return userOptional != null ? userMapper.entityToResponse(userOptional) : null;
    }


}
