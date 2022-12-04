package com.registerapp.registerServerAPI.repository;

import com.registerapp.registerServerAPI.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface SubjectRepository  extends JpaRepository<Subject, Long> {
    @Query(value = "SELECT * FROM subject s INNER JOIN register r ON s.subject_id = r.subject_id WHERE r.teacher_id = ?1 AND r.class_id = ?2", nativeQuery = true)
    Set<Subject> findByTeacherAndClass(Long teacher_id, Long class_id);
}