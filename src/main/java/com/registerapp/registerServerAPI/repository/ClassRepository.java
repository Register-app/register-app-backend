package com.registerapp.registerServerAPI.repository;

import com.registerapp.registerServerAPI.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ClassRepository  extends JpaRepository<Class, Long> {
    @Query(value = "SELECT * FROM class c INNER JOIN register r ON c.class_id = r.class_id WHERE r.teacher_id = ?1", nativeQuery = true)
    Set<Class> findAllByTeacher(Long teacher_id);
}
