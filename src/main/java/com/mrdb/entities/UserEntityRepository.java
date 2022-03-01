package com.mrdb.entities;

import org.springframework.data.repository.CrudRepository;

public interface UserEntityRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findByUserName(String userName);
}
