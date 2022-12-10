package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.entity.Class;
import com.registerapp.registerServerAPI.entity.User;
import com.registerapp.registerServerAPI.repository.ClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClassService {

    private ClassRepository classRepository;

    public Set<Class> getClassesByTeacher(Long teacher_id) {
        return classRepository.findAllByTeacher(teacher_id);
    }

    public List<Class> getClasses() {

        List<Class> classes = classRepository.findAll();
        return classes.stream().sorted(Comparator.comparing(Class::getName)
                .thenComparing(Class::getSchool_year))
                .collect(Collectors.toList());
    }
}
