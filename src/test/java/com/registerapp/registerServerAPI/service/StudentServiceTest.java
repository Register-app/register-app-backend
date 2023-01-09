package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.entity.*;
import com.registerapp.registerServerAPI.entity.Class;
import com.registerapp.registerServerAPI.payload.request.StudentAddRequest;
import com.registerapp.registerServerAPI.payload.response.StudentAddResponse;
import com.registerapp.registerServerAPI.repository.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private ClassRepository classRepository;

    @Mock
    private GuardianRepository guardianRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void addStudent() {
        User user = Mockito.mock(User.class);
        Role role = Mockito.mock(Role.class);
        Class class_ = Mockito.mock(Class.class);
        Student student = Student.builder()
                .user_id(user)
                .class_id(class_)
                .build();

        StudentAddRequest studentAddRequest = StudentAddRequest.builder()
                        .class_id(1L)
                        .user_id(1L)
                        .build();

        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(user));
        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
        when(classRepository.findById(1L)).thenReturn(Optional.ofNullable(class_));
        when(studentRepository.save(Mockito.any(Student.class))).thenReturn(student);

        StudentAddResponse studentAddResponse = studentService.addStudent(studentAddRequest);

        Assertions.assertThat(studentAddResponse).isNotNull();
    }
}