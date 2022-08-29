package com.example.springintroapp.repositories;

import com.example.springintroapp.models.entities.RoleEntity;
import com.example.springintroapp.models.entities.RoleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(RoleNameEnum roleNameEnum);
}
