package com.trainibit.first_api.service.impl;

import com.trainibit.first_api.entity.User;
import com.trainibit.first_api.mapper.UserMapper;
import com.trainibit.first_api.repository.UserRepository;
import com.trainibit.first_api.request.UserRequest;
import com.trainibit.first_api.response.UserResponse;
import com.trainibit.first_api.service.PlanetService;
import com.trainibit.first_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

   @Autowired
   private PlanetService planetService;

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

    //post
    @Override
    public UserResponse saveUser(UserRequest userRequest) {

        User user = userMapper.requestToEntity(userRequest);

        Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());

        user.setCreatedDate(currentTimeStamp);
        user.setUpdatedDate(currentTimeStamp);
        user.setUuid(UUID.randomUUID());

        int idPlanetRandom = (int) (Math.random() * 60) + 1;

        System.out.println(idPlanetRandom);

        String planetResponse = String.valueOf(planetService.getPlanet(idPlanetRandom).getResult().getProperties().getName());
        System.out.println(planetResponse);

        user.setPlanet(planetResponse);

        return userMapper.entityToResponse(userRepository.save(user));

    }




}
