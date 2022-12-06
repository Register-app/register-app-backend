package com.registerapp.registerServerAPI.controller;

import com.registerapp.registerServerAPI.service.GradeValueService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/grade-values")
public class GradeValueController {

    private GradeValueService gradeValueService;

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<?> getGradeValues() throws Exception {
        return ResponseEntity.ok(gradeValueService.getGradeValues());
    }
}