package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.entity.*;
import com.registerapp.registerServerAPI.entity.Class;
import com.registerapp.registerServerAPI.payload.request.StudentAddRequest;
import com.registerapp.registerServerAPI.payload.request.StudentUpdateRequest;
import com.registerapp.registerServerAPI.payload.request.UserUpdateRequest;
import com.registerapp.registerServerAPI.payload.response.StudentAddResponse;
import com.registerapp.registerServerAPI.payload.response.StudentGetResponse;
import com.registerapp.registerServerAPI.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private ClassRepository classRepository;

    public List<StudentGetResponse> getStudentsByClass(Long class_id) {
        List<Student> students = studentRepository.findAllByClass(class_id);

        return students.stream()
                .map(std -> mapToStudentGetResponse(std))
                .collect(Collectors.toList());
    }
        public Student getSingleStudent(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    private StudentGetResponse mapToStudentGetResponse(Student std) {
        return StudentGetResponse.builder()
                .user_id(std.getUser_id().getUser_id())
                .student_id(std.getStudent_id())
                .name(std.getUser_id().getName())
                .second_name(std.getUser_id().getSecond_name())
                .guardian_id(std.getGuardians().stream().map(grd -> grd.getGuardian_id()).collect(Collectors.toList()))
                .class_id(std.getClass_id() != null ? std.getClass_id().getClass_id() : 0)
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

    public StudentAddResponse addStudent(StudentAddRequest studentAddRequest) {
        User user = userRepository.findById(studentAddRequest.getUser_id()).orElseThrow(() -> new IllegalStateException("Użytkownik o id " + studentAddRequest.getUser_id() + " nie istnieje."));
        Set<Role> roles = user.getRoles();
        Role role = roleRepository.findByName("STUDENT");
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);

        Optional<Class> class_ = null;

        if(studentAddRequest.getClass_id() != null && studentAddRequest.getClass_id().toString() != "") {
            class_ = classRepository.findById(studentAddRequest.getClass_id());
        }

        Student student;

        if (class_ != null) {
            student = studentRepository.save(new Student(
                    user,
                    class_.get()
            ));
        } else {
            student = studentRepository.save(new Student(
                    user
            ));
        }

        return StudentAddResponse.builder()
                .student_id(student.getStudent_id())
                .build();
    }

    public void deleteStudent(Long student_id) {
        boolean exists = studentRepository.existsById(student_id);
        if(!exists){
            throw new IllegalStateException("Student o id " + student_id + " nie istnieje.");
        }
        studentRepository.deleteById(student_id);
    }

    public void updateStudent(StudentUpdateRequest studentUpdateRequest) {
        Student student = studentRepository.findById(studentUpdateRequest.getStudent_id()).orElseThrow(() -> new IllegalStateException("Uczeń o id " + studentUpdateRequest.getStudent_id() + " nie istnieje."));

        Optional<Class> class_ = null;

        if(studentUpdateRequest.getClass_id() != null && studentUpdateRequest.getClass_id().toString() != "") {
            class_ = classRepository.findById(studentUpdateRequest.getClass_id());
        }

        if(studentUpdateRequest.getClass_id() != null
                && studentUpdateRequest.getClass_id().toString() != ""
                && !Objects.equals(student.getClass_id().getClass_id(), class_.get().getClass_id())) {
            student.setClass_id(class_.get());
        }

        studentRepository.saveAndFlush(student);
    }
}
