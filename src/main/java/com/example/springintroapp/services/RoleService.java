package com.example.springintroapp.services;

import com.example.springintroapp.models.entities.RoleEntity;
import com.example.springintroapp.models.entities.RoleNameEnum;

public interface RoleService {
    void initRoles();

    RoleEntity findRole(RoleNameEnum roleNameEnum);
}
