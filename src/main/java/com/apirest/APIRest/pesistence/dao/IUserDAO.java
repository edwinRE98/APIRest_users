package com.apirest.APIRest.pesistence.dao;

import com.apirest.APIRest.pesistence.entities.UserEntity;
import java.util.List;
import java.util.Optional;

public interface IUserDAO {
    List<UserEntity> findAll();
    Optional<UserEntity> findById(Integer id);
    void save(UserEntity userEntity);
    void update(UserEntity userEntity);
    void delete(UserEntity userEntity);
}
