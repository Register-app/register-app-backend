package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.entity.Class;
import com.registerapp.registerServerAPI.repository.ClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClassService {

    private ClassRepository classRepository;


    public List<Class> getListClass(Long teacher_id) {
        List<Class> classes = classRepository.findAllByTeacher_id(teacher_id);

        return classes.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
