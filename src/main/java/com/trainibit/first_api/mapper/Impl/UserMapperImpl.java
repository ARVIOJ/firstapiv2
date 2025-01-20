package com.trainibit.first_api.mapper.Impl;

import com.trainibit.first_api.entity.Role;
import com.trainibit.first_api.entity.User;
import com.trainibit.first_api.mapper.UserMapper;
import com.trainibit.first_api.request.UserRequest;
import com.trainibit.first_api.response.UserResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserMapperImpl implements UserMapper {


    @Override
    public UserResponse entityToResponse(User user) {
        UserResponse userResponse = new UserResponse();

        userResponse.setFirstName(user.getName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        userResponse.setBirthDate(user.getBirthday());
        userResponse.setCreatedDate(user.getCreatedDate());
        userResponse.setUpdatedDate(user.getUpdatedDate());
        userResponse.setUuid(user.getUuid());
        userResponse.setAge(calculateAgeMessage(user.getBirthday()));
        userResponse.setPlanet(user.getPlanet());
        // userResponse.setFederalState();
       // userResponse.setRoles();


        return userResponse;
    }

    @Override
    public List<UserResponse> entityToResponseList(List<User> userList) {

        List<UserResponse> userResponseList = new ArrayList<>();

        userList.forEach(user -> userResponseList.add(entityToResponse(user)));

        return userResponseList;

    }

    @Override
    public User requestToEntity(UserRequest userRequest) {

        User user = new User();
        user.setName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setBirthday(LocalDate.parse(userRequest.getBirthdate()));
        return user;
    }

    private String calculateAgeMessage(LocalDate birthDate) {
        LocalDate today = LocalDate.now();
        Period period = Period.between(birthDate, today);

        return "Tienes " + period.getYears() + " años con " +
                period.getMonths() + " meses y " +
                period.getDays() + " días";
    }

}
