package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.entity.Class;
import com.registerapp.registerServerAPI.repository.ClassRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClassServiceTest {

    @Mock
    private ClassRepository classRepository;

    @InjectMocks
    private ClassService classService;

    @Test
    void getClassesByTeacher() {
        Class class_ = Class.builder()
                .school_year("2022/2023")
                .name("I A")
                .build();

        when(classRepository.findAllByTeacher(1L)).thenReturn(Set.of(class_));

        Set<Class> foundClasses = classService.getClassesByTeacher(1L);

        Assertions.assertThat(foundClasses).isNotNull();
    }
}