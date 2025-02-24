package com.trainibit.first_api.service.impl;

import com.trainibit.first_api.entity.FederalState;
import com.trainibit.first_api.entity.Role;
import com.trainibit.first_api.entity.RolesByUser;
import com.trainibit.first_api.entity.User;
import com.trainibit.first_api.mapper.UserMapper;
import com.trainibit.first_api.repository.FederalStateRepository;
import com.trainibit.first_api.repository.RoleRepository;
import com.trainibit.first_api.repository.UserRepository;
import com.trainibit.first_api.request.RolesRequest;
import com.trainibit.first_api.request.UserRequest;
import com.trainibit.first_api.response.KafkaResponse;
import com.trainibit.first_api.response.UserResponse;
import com.trainibit.first_api.service.KafkaMessageProducer;
import com.trainibit.first_api.service.PlanetService;
import com.trainibit.first_api.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PlanetService planetService;

    @Autowired
    private FederalStateRepository federalStateRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private KafkaMessageProducer kafkaMessageProducer;

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
        FederalState federalState = federalStateRepository.findByUuid(userRequest.getFederalState());

        User user = userMapper.requestToEntity(userRequest, federalState);

        Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());

        user.setCreatedDate(currentTimeStamp);
        user.setUpdatedDate(currentTimeStamp);
        user.setUuid(UUID.randomUUID());
        user.setPlanet(getRandomPlanetName());
        user.setFederalState(federalState);
        user.setToken(createToken());

        List<RolesByUser> roles = new ArrayList<>();

        if (userRequest.getRoles() != null) {
            for (RolesRequest rolesRequest : userRequest.getRoles()) {
                Role role = roleRepository.findByUuid(rolesRequest.getUuid());
                RolesByUser rolesByUser = new RolesByUser();
                rolesByUser.setUser(user);
                rolesByUser.setRole(role);
                rolesByUser.setUuid(UUID.randomUUID());
                roles.add(rolesByUser);
            }
            user.setRoles(roles);
        }

        User saveUser = userRepository.save(user);

        KafkaResponse kafkaResponse = new KafkaResponse();

        kafkaResponse.setUuid(saveUser.getUuid());
        kafkaResponse.setEmail(saveUser.getEmail());
        kafkaResponse.setToken(saveUser.getToken());

        kafkaMessageProducer.sendMessage(kafkaResponse);

        return userMapper.entityToResponse(saveUser);
    }

    @Override
    // @Transactional
    public void deleteUser(UUID uuid) {
        userRepository.delete(userRepository.findByUuid(uuid));
    }

    //actualizar
    @Override
    //@Transactional //que es
    public UserResponse updateUser(UUID uuid, UserRequest userRequest) {
        User existingUser = userRepository.findByUuid(uuid);
        if (existingUser != null) {
            FederalState federalState = federalStateRepository.findByUuid(userRequest.getFederalState());
            existingUser.setName(userRequest.getFirstName());
            existingUser.setLastName(userRequest.getLastName());
            existingUser.setEmail(userRequest.getEmail());
            existingUser.setBirthday(LocalDate.parse(userRequest.getBirthdate()));
            existingUser.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
            existingUser.setFederalState(federalState);

            // Clear existing roles
            existingUser.getRoles().clear();

            List<RolesByUser> roles = new ArrayList<>();
            Set<UUID> uniqueRoleUuids = new HashSet<>();
            if (userRequest.getRoles() != null) {
                for (RolesRequest rolesRequest : userRequest.getRoles()) {
                    if (uniqueRoleUuids.add(rolesRequest.getUuid())) {
                        Role role = roleRepository.findByUuid(rolesRequest.getUuid());
                        RolesByUser rolesByUser = new RolesByUser();
                        rolesByUser.setUser(existingUser);
                        rolesByUser.setRole(role);
                        rolesByUser.setUuid(UUID.randomUUID());
                        roles.add(rolesByUser);
                    }
                }
                existingUser.getRoles().addAll(roles);
            }

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

    private String createToken() {
        Random random = new Random();
        return 100000 + random.nextInt(900000) + "";
    }


}
