package com.registerapp.registerServerAPI.repository;

import com.registerapp.registerServerAPI.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "SELECT * FROM student s WHERE s.class_id = ?1", nativeQuery = true)
    List<Student> findAllByClass(Long class_id);

    @Query(value = "SELECT * FROM student s WHERE s.user_id = ?1", nativeQuery = true)
    Optional<Student> findByUser(Long user_id);
}
