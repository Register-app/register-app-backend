package com.registerapp.registerServerAPI.repository;

import com.registerapp.registerServerAPI.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository  extends JpaRepository<Attendance, Long> {

    @Query(value = "SELECT * FROM attendance a WHERE a.user_id = ?1", nativeQuery = true)
    List<Attendance> findAllByStudent_id(Long student_id);
}
