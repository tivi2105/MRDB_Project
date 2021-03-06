package com.mrdb.repositories;

import com.mrdb.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserEntityRepository extends CrudRepository<UserEntity, Integer> {
    List<UserEntity> findByUserNameAndPassword(String userName, String password);
    List<UserEntity> findByEmail(String email);
    UserEntity findByUserName(String userName);
}
