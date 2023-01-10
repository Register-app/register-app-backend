package com.registerapp.registerServerAPI.controller;

import com.registerapp.registerServerAPI.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping("/student/{student_id}/date/{date}")
    @PreAuthorize("hasAnyRole('STUDENT')")
    public ResponseEntity<?> getStudentSchedule(@PathVariable Long student_id, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime ldt) {
        return ResponseEntity.ok(scheduleService.getStudentSchedule(student_id, ldt));
    }

    @GetMapping("/class/{class_id}/date/{date}")
    @PreAuthorize("hasAnyRole('TEACHER')")
    public ResponseEntity<?> getClassSchedule(@PathVariable Long class_id, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime ldt) {
        return ResponseEntity.ok(scheduleService.getClassSchedule(class_id, ldt));
    }
}
