package com.registerapp.registerServerAPI.controller;


import com.registerapp.registerServerAPI.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {

    private TeacherService teacherService;

    @GetMapping("/user/{user_id}")
    @PreAuthorize("hasAnyRole('TEACHER')")
    public ResponseEntity<?> getTeacher(@PathVariable Long user_id) throws Exception {
        return ResponseEntity.ok(teacherService.getTeacherByUser_id(user_id));
    }
}
