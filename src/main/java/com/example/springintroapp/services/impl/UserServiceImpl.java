package com.example.springintroapp.services.impl;

import com.example.springintroapp.models.entities.RoleNameEnum;
import com.example.springintroapp.models.entities.UserEntity;
import com.example.springintroapp.models.services.UserServiceModel;
import com.example.springintroapp.repositories.UserRepository;
import com.example.springintroapp.security.CurrentUser;
import com.example.springintroapp.services.RoleService;
import com.example.springintroapp.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService, CurrentUser currentUser, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }


    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);
        user.setRole(roleService.findRole(RoleNameEnum.USER));

        userRepository.save(user);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        return userRepository
                .findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void login(UserServiceModel userServiceModel) {
        currentUser
                .setId(userServiceModel.getId())
                .setUsername(userServiceModel.getUsername())
                .setRole(userServiceModel.getRole().getName());
    }

    @Override
    public void logout() {
        currentUser
                .setId(null)
                .setUsername(null)
                .setRole(null);
    }

    @Override
    public List<String> findAllUsernames() {
        return userRepository.findAllUsernames();
    }

    @Override
    public void changeRole(String username, RoleNameEnum roleNameEnum) {
        UserEntity user = userRepository
                .findByUsername(username)
                .orElse(null);

        if (user.getRole().getName() != roleNameEnum) {
            user.setRole(roleService.findRole(roleNameEnum));

            userRepository.save(user);
        }
    }
}
