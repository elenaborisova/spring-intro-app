package com.example.springintroapp.repositories;

import com.example.springintroapp.models.entities.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseEntity, Long> {
    @Query("SELECT e FROM ExerciseEntity e ORDER BY e.name")
    List<String> findAllNames();

    Optional<ExerciseEntity> findByName(String name);

}
