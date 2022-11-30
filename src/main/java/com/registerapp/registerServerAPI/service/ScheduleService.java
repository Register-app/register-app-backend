package com.registerapp.registerServerAPI.service;


import com.registerapp.registerServerAPI.entity.Schedule;
import com.registerapp.registerServerAPI.payload.response.ScheduleGetResponse;
import com.registerapp.registerServerAPI.repository.ScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ScheduleService {
    private ScheduleRepository scheduleRepository;

        public List<ScheduleGetResponse> getStudentAttendance(Long student_id, LocalDateTime date) {
            List<Schedule> scheduleList =  scheduleRepository.findStudentScheduleByDate(student_id, date);
            return scheduleList.stream()
                    .map(schd -> mapToScheduleGetResponse(schd))
                    .collect(Collectors.toList());
    }

    private ScheduleGetResponse mapToScheduleGetResponse(Schedule schd) {
            return ScheduleGetResponse.builder()
                    .schedule_id(schd.getSchedule_id())
                    .schedule_type_id(schd.getSchedule_type_id().getName())
                    //.student_id(schd.getRegister_id().getClass_id())
                    .register_id(schd.getRegister_id().getRegister_id())
                    .teacher_id(schd.getRegister_id().getTeacher_id().getTeacher_id())
                    .subject(schd.getRegister_id().getSubject_id().getName())
                    .date(schd.getDate())
                    .build();
    }
}
