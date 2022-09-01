package com.example.springintroapp.repositories;

import com.example.springintroapp.models.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    @Query("SELECT c.author.username FROM CommentEntity c GROUP BY c.author.username ORDER BY avg(c.score) DESC")
    List<String> findTopByAvgScore();

    @Query("SELECT AVG(c.score) FROM CommentEntity c ")
    Double findAvgScore();
}
