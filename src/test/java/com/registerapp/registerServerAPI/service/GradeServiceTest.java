package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.entity.*;
import com.registerapp.registerServerAPI.payload.request.GradeAddRequest;
import com.registerapp.registerServerAPI.payload.response.GradeAddResponse;
import com.registerapp.registerServerAPI.repository.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GradeServiceTest {

    @Mock
    private GradeRepository gradeRepository;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private RegisterRepository registerRepository;

    @Mock
    private GradeTypeRepository gradeTypeRepository;

    @Mock
    private GradeValueRepository gradeValueRepository;

    @InjectMocks
    private GradeService gradeService;

    @Test
    public void testAddGrade() {
        Student student = Mockito.mock(Student.class);
        Register register = Mockito.mock(Register.class);
        GradeValue gradeValue = Mockito.mock(GradeValue.class);
        GradeType gradeType = Mockito.mock(GradeType.class);
        Grade grade = Grade.builder()
                .grade_id(1L)
                .grade_value_id(gradeValue)
                .grade_type_id(gradeType)
                .date(LocalDateTime.now())
                .comment("Test")
                .register_id(register)
                .student_id(student)
                .weight(1)
                .build();

        GradeAddRequest gradeAddRequest = GradeAddRequest.builder()
                .weight(1)
                .grade_value_id(1L)
                .grade_type_id(1L)
                .comment("Test")
                .date(LocalDateTime.now())
                .student_id(1L)
                .build();

        when(studentRepository.findById(1L)).thenReturn(Optional.ofNullable(student));
        when(gradeValueRepository.findById(1L)).thenReturn(Optional.ofNullable(gradeValue));
        when(gradeTypeRepository.findById(1L)).thenReturn(Optional.ofNullable(gradeType));
        when(gradeRepository.save(Mockito.any(Grade.class))).thenReturn(grade);

        GradeAddResponse gradeAddResponse = gradeService.addGrade(gradeAddRequest);

        Assertions.assertThat(gradeAddResponse).isNotNull();
    }
}