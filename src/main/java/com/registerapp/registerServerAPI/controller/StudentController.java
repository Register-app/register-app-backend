package com.registerapp.registerServerAPI.controller;

import com.registerapp.registerServerAPI.entity.Student;
import com.registerapp.registerServerAPI.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

//    @GetMapping("/students")
//    public List<Student> getStudents(){
//        return studentService.getStudents();
//    }
//
//    @GetMapping("/students/{id}")
//    public Student getStudent(@PathVariable Long id){
//        return studentService.getSingleStudent(id);
//    }

    @GetMapping("/class/{class_id}")
    @PreAuthorize("hasAnyRole('TEACHER')")
    public ResponseEntity<?> getStudentsByClass(@PathVariable Long class_id) throws Exception {
        return ResponseEntity.ok(studentService.getStudentsByClass(class_id));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> getStudents() throws Exception {
        return ResponseEntity.ok(studentService.getStudents());
    }
}
