package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.entity.Class;
import com.registerapp.registerServerAPI.entity.Student;
import com.registerapp.registerServerAPI.payload.response.GuardianGetResponse;
import com.registerapp.registerServerAPI.payload.response.StudentGetResponse;
import com.registerapp.registerServerAPI.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
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

    public List<StudentGetResponse> getStudentsByClass(Long class_id) {
        List<Student> students = studentRepository.findAllByClass(class_id);

        return students.stream()
                .map(std -> mapToStudentGetResponse(std))
                .collect(Collectors.toList());
    }

    private StudentGetResponse mapToStudentGetResponse(Student std) {
        return StudentGetResponse.builder()
                .user_id(std.getUser_id().getUser_id())
                .student_id(std.getStudent_id())
                .name(std.getUser_id().getName())
                .second_name(std.getUser_id().getSecond_name())
                .guardian_id(std.getGuardians().stream().map(grd -> grd.getGuardian_id()).collect(Collectors.toList()))
                .class_id(std.getClass_id().getClass_id())
                .email(std.getUser_id().getEmail())
                .build();
    }

    public List<StudentGetResponse> getStudents() {
        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map(std -> mapToStudentGetResponse(std))
                .sorted(Comparator.comparing(StudentGetResponse::getSecond_name))
                .collect(Collectors.toList());
    }
}
