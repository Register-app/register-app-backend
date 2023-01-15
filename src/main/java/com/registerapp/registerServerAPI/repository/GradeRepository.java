package com.registerapp.registerServerAPI.repository;

import com.registerapp.registerServerAPI.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Repository
public interface GradeRepository  extends JpaRepository<Grade, Long> {

    @Query(value = "SELECT * FROM grade g " +
            "INNER JOIN register r ON r.register_id = g.register_id " +
            "WHERE r.class_id = ?1 AND r.subject_id = ?2", nativeQuery = true)

    Set<Grade> findAllByClassAndSubject(Long class_id, Long subject_id);

    @Query(value = "SELECT * FROM grade g inner join register r on g.register_id = r.register_id inner join subject s on r.subject_id = s.subject_id inner join grade_type gt on gt.grade_type_id = g.grade_type_id inner join grade_value gv on gv.grade_value_id = g.grade_value_id WHERE g.student_id = ?1 and DATE(g.date)= DATE(?2)", nativeQuery = true)
    List<Grade> findAllByStudentId(Long student_id, LocalDateTime date);
}