package com.mrdb.entities;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserEntityRepository extends CrudRepository<UserEntity, Integer> {
    List<UserEntity> findByUserNameAndPassword(String userName, String password);
    List<UserEntity> findByEmail(String email);
    UserEntity findByUserName(String userName);
}
