package com.trainibit.first_api.service.impl;

import com.trainibit.first_api.entity.User;
import com.trainibit.first_api.mapper.UserMapper;
import com.trainibit.first_api.repository.UserRepository;
import com.trainibit.first_api.request.UserRequest;
import com.trainibit.first_api.response.UserResponse;
import com.trainibit.first_api.service.PlanetService;
import com.trainibit.first_api.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
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
        user.setPlanet(getRandomPlanetName());

        return userMapper.entityToResponse(userRepository.save(user));
    }

    @Override
    // @Transactional
    public void deleteUser(UUID uuid) {
        userRepository.deleteByUuid(uuid);
    }

    //actualizar
    @Override
    //@Transactional //que es
    public  UserResponse updateUser(UUID uuid, UserRequest userRequest){
        User existingUser = userRepository.findByUuid(uuid);
        if (existingUser != null) {
            existingUser.setName(userRequest.getFirstName());
            existingUser.setLastName(userRequest.getLastName());
            existingUser.setEmail(userRequest.getEmail());
            existingUser.setBirthday(LocalDate.parse(userRequest.getBirthdate()));
            existingUser.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
            return userMapper.entityToResponse(userRepository.save(existingUser));
        } else {
            return null;
        }
    }

    private String getRandomPlanetName() {
        int idPlanetRandom = (int) (Math.random() * 60) + 1;
        System.out.println(idPlanetRandom);
        String planetResponse = String.valueOf(planetService.getPlanet(idPlanetRandom).getResult().getProperties().getName());
        System.out.println(planetResponse);
        return planetResponse;
    }

}
