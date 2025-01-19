package com.trainibit.first_api.controller;

// importaciones deben ir lexicograficamente

import com.trainibit.first_api.entity.User;
import com.trainibit.first_api.request.UserRequest;
import com.trainibit.first_api.response.UserResponse;
import com.trainibit.first_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

// notacion
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers() {

        return ResponseEntity.ok(userService.findAll());
    }

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

    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserRequest userRequest) {
        UserResponse newUser = userService.saveUser(userRequest);
        return ResponseEntity.ok(newUser);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID uuid){
        userService.deleteUser(uuid);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable UUID uuid, @RequestBody UserRequest userRequest) {
        UserResponse updatedUser = userService.updateUser(uuid, userRequest);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
