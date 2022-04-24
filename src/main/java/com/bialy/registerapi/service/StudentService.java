package com.bialy.registerapi.service;

import com.bialy.registerapi.model.Student;
import com.bialy.registerapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getSingleStudent(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }
}
