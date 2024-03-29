package com.registerapp.registerServerAPI.controller;

import com.registerapp.registerServerAPI.service.ClassService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/classes")
public class ClassController {

    private ClassService classService;

    @GetMapping("/teacher/{teacher_id}")
    @PreAuthorize("hasAnyRole('TEACHER')")
    public ResponseEntity<?> getClassesByTeacher(@PathVariable Long teacher_id) throws Exception {
        return ResponseEntity.ok(classService.getClassesByTeacher(teacher_id));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> getClasses() throws Exception {
        return ResponseEntity.ok(classService.getClasses());
    }
}
