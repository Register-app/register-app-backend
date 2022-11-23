package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.entity.Class;
import com.registerapp.registerServerAPI.entity.Student;
import com.registerapp.registerServerAPI.payload.response.StudentGetResponse;
import com.registerapp.registerServerAPI.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;

//    public List<Student> getStudents() {
//        return studentRepository.findAll();
//    }
//
//    public Student getSingleStudent(Long id) {
//        return studentRepository.findById(id).orElseThrow();
//    }

    public List<StudentGetResponse> getListStudent(Long class_id) {
        List<Student> students = studentRepository.findAllByClass_id(class_id);

        return students.stream()
                .map(std -> mapToStudentGetResponse(std))
                .collect(Collectors.toList());
    }

    private StudentGetResponse mapToStudentGetResponse(Student std) {
        return StudentGetResponse.builder()
                .student_id(std.getStudent_id())
                .name(std.getUser_id().getName())
                .second_name(std.getUser_id().getSecond_name())
                .build();
    }
}
