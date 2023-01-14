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

        public List<ScheduleGetResponse> getStudentSchedule(Long student_id, LocalDateTime date) {
            List<Schedule> scheduleList =  scheduleRepository.findStudentScheduleByDate(student_id, date);
            return scheduleList.stream()
                    .map(schd -> mapToScheduleGetResponse(schd))
                    .collect(Collectors.toList());
    }
    public List<ScheduleGetResponse> getTeacherSchedule(Long teacher_id, LocalDateTime date) {
        List<Schedule> scheduleList =  scheduleRepository.findTeacherScheduleByDate(teacher_id, date);
        return scheduleList.stream()
                .map(schd -> mapToScheduleGetResponse(schd))
                .collect(Collectors.toList());
    }

    public List<ScheduleGetResponse> getClassSchedule(Long class_id, LocalDateTime date) {
        List<Schedule> scheduleList =  scheduleRepository.findClassScheduleByDate(class_id, date);
        return scheduleList.stream()
                .map(schd -> mapToScheduleGetResponse(schd))
                .collect(Collectors.toList());
    }

    private ScheduleGetResponse mapToScheduleGetResponse(Schedule schd) {
            return ScheduleGetResponse.builder()
                    .schedule_id(schd.getSchedule_id())
                    .schedule_type_id(schd.getSchedule_type_id().getName())
                    .register_id(schd.getRegister_id().getRegister_id())
                    .class_id(schd.getRegister_id().getClass_id().getClass_id())
                    .class_name(schd.getRegister_id().getClass_id().getName())
                    .teacher_id(schd.getRegister_id().getTeacher_id().getTeacher_id())
                    .name(schd.getRegister_id().getTeacher_id().getUser_id().getName())
                    .second_name(schd.getRegister_id().getTeacher_id().getUser_id().getSecond_name())
                    .subject(schd.getRegister_id().getSubject_id().getName())
                    .date(schd.getDate())
                    .build();
    }
}
