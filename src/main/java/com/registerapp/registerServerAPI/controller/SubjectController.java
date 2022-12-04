package com.registerapp.registerServerAPI.controller;

import com.registerapp.registerServerAPI.service.ClassService;
import com.registerapp.registerServerAPI.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/subjects")
public class SubjectController {

    private SubjectService subjectService;

    @GetMapping("/teacher/{teacher_id}/class/{class_id}")
    @PreAuthorize("hasAnyRole('TEACHER')")
    public ResponseEntity<?> getSubjectsByTeacherAndClass(@PathVariable Long teacher_id, @PathVariable Long class_id) throws Exception {
        return ResponseEntity.ok(subjectService.getSubjectsByTeacherAndClass(teacher_id, class_id));
    }
}
