package com.registerapp.registerServerAPI.repository;

import com.registerapp.registerServerAPI.entity.Attendance;
import com.registerapp.registerServerAPI.entity.Schedule;
import com.registerapp.registerServerAPI.entity.ScheduleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query(value = "select * from schedule s inner join register r on s.register_id = r.register_id inner join schedule_type st on st.schedule_type_id = s.schedule_type_id inner join class c on c.class_id = r.class_id  inner join student std on std.class_id = c.class_id inner join teacher t on r.teacher_id=t.teacher_id inner join user u on u.user_id=t.user_id where std.student_id = ?1 and DATE(s.date)= DATE(?2) ORDER BY s.date", nativeQuery = true)
    List<Schedule> findStudentScheduleByDate(Long student_id, LocalDateTime date);

    @Query(value = "select * from schedule s inner join register r on s.register_id = r.register_id inner join schedule_type st on st.schedule_type_id = s.schedule_type_id inner join class c on c.class_id = r.class_id  where r.class_id = ?1 and DATE(s.date)= DATE(?2) ORDER BY s.date", nativeQuery = true)
    List<Schedule> findClassScheduleByDate(Long class_id, LocalDateTime date);

    @Query(value = "select * from schedule s inner join register r on s.register_id = r.register_id inner join schedule_type st on st.schedule_type_id = s.schedule_type_id inner join class c on c.class_id = r.class_id  inner join student std on std.class_id = c.class_id inner join teacher t on r.teacher_id=t.teacher_id inner join user u on u.user_id=t.user_id  where r.teacher_id = ?1 and DATE(s.date)= DATE(?2) GROUP BY r.register_id ORDER BY s.date", nativeQuery = true)
    List<Schedule> findTeacherScheduleByDate(Long teacher_id, LocalDateTime date);}
