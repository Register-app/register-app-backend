package com.registerapp.registerServerAPI.repository;

import com.registerapp.registerServerAPI.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository  extends JpaRepository<Register, Long> {

    @Query(value = "SELECT * FROM register r " +
            "WHERE r.class_id = ?1 AND r.teacher_id = ?2 AND r.subject_id = ?3", nativeQuery = true)
    Register findByClassAndTeacherAndSubject(Long class_id, Long teacher_id, Long subject_id);
}