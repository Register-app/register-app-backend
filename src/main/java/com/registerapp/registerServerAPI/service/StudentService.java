package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.entity.Student;
import com.registerapp.registerServerAPI.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getSingleStudent(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }
}
