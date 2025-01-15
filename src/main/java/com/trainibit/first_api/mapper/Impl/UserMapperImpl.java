package com.trainibit.first_api.mapper.Impl;

import com.trainibit.first_api.entity.User;
import com.trainibit.first_api.mapper.UserMapper;
import com.trainibit.first_api.response.UserResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
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

//        //↓↓↓↓↓↓ Calcular años meses y dias ↓↓↓↓↓↓ //crear un metodo o lambads
        LocalDate hoy = LocalDate.now();
        LocalDate nacimiento = user.getBirthday();
        Period periodo = Period.between(nacimiento, hoy);

        String ageMessage = "Tienes " + periodo.getYears() + " años con " +
                periodo.getMonths() + " meses y " +
                periodo.getDays() + " días";
//        //↑↑↑↑↑ Calcular años meses y dias ↑↑↑↑↑

        userResponse.setAge(ageMessage);

        return userResponse;
    }

    @Override
    public List<UserResponse> entityToResponseList(List<User> userList) {

        List<UserResponse> userResponseList = new ArrayList<>();

        userList.forEach(user -> userResponseList.add(entityToResponse(user)));

        return userResponseList;

    }


}
