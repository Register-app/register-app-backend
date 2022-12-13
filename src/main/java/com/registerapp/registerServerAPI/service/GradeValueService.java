package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.entity.GradeValue;
import com.registerapp.registerServerAPI.repository.GradeValueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GradeValueService {

    private GradeValueRepository gradeValueRepository;

    public List<GradeValue> getGradeValues() {
        return gradeValueRepository.findAll();
    }
}