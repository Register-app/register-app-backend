package com.registerapp.registerServerAPI.service;


import com.registerapp.registerServerAPI.entity.Attendance;
import com.registerapp.registerServerAPI.entity.Student;
import com.registerapp.registerServerAPI.payload.response.AttendanceGetResponse;
import com.registerapp.registerServerAPI.payload.response.StudentGetResponse;
import com.registerapp.registerServerAPI.repository.AttendanceRepository;
import com.registerapp.registerServerAPI.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AttendanceService {
    private AttendanceRepository attendanceRepository;

        public List<AttendanceGetResponse> getStudentAttendance(Long student_id, LocalDateTime date) {
            List<Attendance> attendanceList =  attendanceRepository.findStudentAttendanceByDate(student_id, date);
            return attendanceList.stream()
                    .map(attd -> mapToAttendanceGetResponse(attd))
                    .collect(Collectors.toList());
    }

    private AttendanceGetResponse mapToAttendanceGetResponse(Attendance attd) {
            return AttendanceGetResponse.builder()
                    .attendance_id(attd.getAttendance_id())
                    .student_id(attd.getStudent_id().getStudent_id())
                    .subject(attd.getRegister_id().getSubject_id().getName())
                    .attendance_type(attd.getAttendance_type_id().getName())
                    .date(attd.getDate())
                    .build();
    }
}
