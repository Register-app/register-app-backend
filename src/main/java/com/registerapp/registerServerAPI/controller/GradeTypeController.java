package com.registerapp.registerServerAPI.controller;

import com.registerapp.registerServerAPI.service.GradeTypeService;
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
@RequestMapping("/api/v1/grade-types")
public class GradeTypeController {

    private GradeTypeService gradeTypeService;

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<?> getGradeTypes() throws Exception {
        return ResponseEntity.ok(gradeTypeService.getGradeTypes());
    }
}
