package com.example.springintroapp.services;

import com.example.springintroapp.models.entities.RoleNameEnum;
import com.example.springintroapp.models.entities.UserEntity;
import com.example.springintroapp.models.services.UserServiceModel;

import java.util.List;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void login(UserServiceModel userServiceModel);

    void logout();

    List<String> findAllUsernames();

    void changeRole(String username, RoleNameEnum roleNameEnum);

    UserEntity findById(Long id);
}
