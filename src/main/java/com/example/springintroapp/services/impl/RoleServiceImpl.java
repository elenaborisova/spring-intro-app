package com.example.springintroapp.services.impl;

import com.example.springintroapp.models.entities.RoleEntity;
import com.example.springintroapp.models.entities.RoleNameEnum;
import com.example.springintroapp.repositories.RoleRepository;
import com.example.springintroapp.services.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initRoles() {
        if (roleRepository.count() == 0) {
            RoleEntity admin = new RoleEntity(RoleNameEnum.ADMIN);
            RoleEntity user = new RoleEntity(RoleNameEnum.USER);

            roleRepository.save(admin);
            roleRepository.save(user);
        }
    }
}
