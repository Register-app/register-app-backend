package com.registerapp.registerServerAPI.controller;

import com.registerapp.registerServerAPI.payload.request.GradeAddRequest;
import com.registerapp.registerServerAPI.payload.request.GradeUpdateRequest;
import com.registerapp.registerServerAPI.payload.response.MessageResponse;
import com.registerapp.registerServerAPI.service.GradeService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/grades")
public class GradeController {

    private GradeService gradeService;

    @GetMapping("/class/{class_id}/subject/{subject_id}")
    @PreAuthorize("hasAnyRole('TEACHER')")
    public ResponseEntity<?> getGradesByClassAndSubject(@PathVariable Long class_id, @PathVariable Long subject_id) throws Exception {
        return ResponseEntity.ok(gradeService.getGradesByClassAndSubject(class_id, subject_id));
    }
    @GetMapping("/student/{student_id}/date/{date}")
    public ResponseEntity<?> getGradesByStudentId(@PathVariable Long student_id,  @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime ldt) throws Exception {
        return ResponseEntity.ok(gradeService.findAllByStudentId(student_id, ldt));
    }

    @PostMapping("/grade")
    @PreAuthorize("hasAnyRole('TEACHER')")
    public ResponseEntity<?> addGrade(@RequestBody GradeAddRequest gradeAddRequest) throws Exception {
        return ResponseEntity.ok(gradeService.addGrade(gradeAddRequest));
    }

    @PutMapping("/grade")
    @PreAuthorize("hasAnyRole('TEACHER')")
    public ResponseEntity<?> updateGrade(@RequestBody GradeUpdateRequest gradeUpdateRequest) throws Exception {
        gradeService.updateGrade(gradeUpdateRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/grade/{grade_id}")
    @PreAuthorize("hasAnyRole('TEACHER')")
    public ResponseEntity<?> deleteGrade(@PathVariable Long grade_id) throws Exception {
        gradeService.deleteGrade(grade_id);
        return ResponseEntity.noContent().build();
    }
}
