package com.example.springintroapp.services.impl;

import com.example.springintroapp.models.entities.RoleNameEnum;
import com.example.springintroapp.models.entities.UserEntity;
import com.example.springintroapp.models.services.UserServiceModel;
import com.example.springintroapp.repositories.UserRepository;
import com.example.springintroapp.services.RoleService;
import com.example.springintroapp.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);
        user.setRole(roleService.findRole(RoleNameEnum.USER));

        userRepository.save(user);
    }
}
