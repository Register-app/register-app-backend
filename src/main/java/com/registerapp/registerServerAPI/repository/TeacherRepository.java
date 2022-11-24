package com.registerapp.registerServerAPI.repository;

import com.registerapp.registerServerAPI.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository  extends JpaRepository<Teacher, Long> {
    @Query(value = "SELECT * FROM teacher t WHERE t.user_id = ?1", nativeQuery = true)
    Optional<Teacher> findByUser_id(Long user_id);
}