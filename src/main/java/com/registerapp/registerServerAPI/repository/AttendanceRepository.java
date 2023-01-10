package com.registerapp.registerServerAPI.repository;

import com.registerapp.registerServerAPI.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AttendanceRepository  extends JpaRepository<Attendance, Long> {

    @Query(value = "SELECT * FROM attendance WHERE student_id = ?1", nativeQuery = true)
    List<Attendance> findAllByStudent_id(Long student_id);
    @Query(value = "SELECT * FROM attendance a INNER JOIN register r ON a.register_id=r.register_id INNER JOIN schedule s ON s.register_id=r.register_id WHERE a.student_id = ?1 AND Date(s.date)=Date(?2) ORDER BY s.date", nativeQuery = true)
    List<Attendance> findStudentAttendanceByDate(Long student_id, LocalDateTime date);

    @Query(value = "SELECT * FROM attendance a INNER JOIN register r ON a.register_id=r.register_id INNER JOIN schedule s ON s.register_id=r.register_id WHERE r.class_id = ?1 AND Date(s.date)=Date(?2) ORDER BY s.date", nativeQuery = true)
    List<Attendance> findClassAttendanceByDate(Long class_id, LocalDateTime date);

    @Query(value = "SELECT * FROM attendance a INNER JOIN register r ON a.register_id=r.register_id INNER JOIN schedule s ON s.register_id=r.register_id WHERE r.class_id = ?1 AND Date(s.date)=Date(?3) AND r.subject_id=?2 ORDER BY s.date", nativeQuery = true)
    List<Attendance> findClassAttendanceBySubject(Long class_id, Long subject_id, LocalDateTime date);

}
