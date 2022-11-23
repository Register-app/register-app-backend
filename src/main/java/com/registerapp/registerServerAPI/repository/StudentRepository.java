package com.registerapp.registerServerAPI.repository;

import com.registerapp.registerServerAPI.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "SELECT * FROM student s WHERE s.class_id = ?1", nativeQuery = true)
    List<Student> findAllByClass_id(Long class_id);
}
