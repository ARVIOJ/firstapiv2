package com.trainibit.first_api.controller;

// importaciones deben ir lexicograficamente

import com.trainibit.first_api.response.UserResponse;
import com.trainibit.first_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

// notacion
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers() {

        return ResponseEntity.ok(userService.findAll());
    }

    // ESTO ES NUEVO
    //BUSCAR POR UUID
    @GetMapping("/{uuid}")
    public ResponseEntity<UserResponse> getById(@PathVariable UUID uuid) {
        UserResponse userResponse = userService.findByUuid(uuid);
        if (userResponse != null) {
            return ResponseEntity.ok(userResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }





}
