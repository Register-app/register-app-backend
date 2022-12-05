package com.registerapp.registerServerAPI.repository;

import com.registerapp.registerServerAPI.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface GradeRepository  extends JpaRepository<Grade, Long> {

    @Query(value = "SELECT * FROM grade g " +
            "INNER JOIN register r ON r.register_id = g.register_id " +
            "WHERE r.class_id = ?1 AND r.subject_id = ?2", nativeQuery = true)

    Set<Grade> findAllByClassAndSubject(Long class_id, Long subject_id);
}