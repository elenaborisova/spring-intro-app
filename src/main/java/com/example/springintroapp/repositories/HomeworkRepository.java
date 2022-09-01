package com.example.springintroapp.repositories;

import com.example.springintroapp.models.entities.HomeworkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HomeworkRepository extends JpaRepository<HomeworkEntity, Long> {
    Optional<HomeworkEntity> findTop1ByOrderByCommentsSet();
}
