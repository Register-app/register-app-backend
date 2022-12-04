package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.entity.Subject;
import com.registerapp.registerServerAPI.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class SubjectService {

    private SubjectRepository subjectRepository;

    public Set<Subject> getSubjectsByTeacherAndClass(Long teacher_id, Long class_id) {
        return subjectRepository.findByTeacherAndClass(teacher_id, class_id);
    }
}
