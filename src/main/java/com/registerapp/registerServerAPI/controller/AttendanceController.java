package com.registerapp.registerServerAPI.controller;

import com.registerapp.registerServerAPI.entity.Attendance;
import com.registerapp.registerServerAPI.service.AttendanceService;
import com.registerapp.registerServerAPI.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

//     @GetMapping("/attendance/{student_id}/{date}")
//     public List<Attendance> getStudentAttendance(@PathVariable Long student_id, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime ldt) {
//         return attendanceService.getStudentAttendance(student_id, ldt);
//
//     }

    @GetMapping("/student/{student_id}/date/{date}")
    @PreAuthorize("hasAnyRole('STUDENT')")
    public ResponseEntity<?> getStudentAttendance(@PathVariable Long student_id, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime ldt) {
        return ResponseEntity.ok(attendanceService.getStudentAttendance(student_id, ldt));
    }



//        @GetMapping("/attendance/{student_id}/{date}")
//        public List<Attendance> getStudentAttendance(@PathVariable Long student_id, @PathVariable LocalDateTime date) {
//            return attendanceService.getStudentAttendance(student_id, date);
//        }

//    public List<Student> getStudents(){
//        return studentService.getStudents();
//    }
//
//    @GetMapping("/students/{id}")
//    public Student getStudent(@PathVariable Long id){
//        return studentService.getSingleStudent(id);
//    }

}
