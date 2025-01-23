package com.trainibit.first_api.repository;

import com.trainibit.first_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    User findByUuid(UUID uuid);

    //eliminar por uuid
    void deleteByUuid(UUID uuid);

    //actualizar por uuid


}
