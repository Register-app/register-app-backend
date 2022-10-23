package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.model.Student;
import com.registerapp.registerServerAPI.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getSingleStudent(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }
}
