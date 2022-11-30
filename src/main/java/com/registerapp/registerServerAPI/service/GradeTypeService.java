package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.entity.GradeType;
import com.registerapp.registerServerAPI.repository.GradeTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GradeTypeService {

    private GradeTypeRepository gradeTypeRepository;

    public List<GradeType> getGradeTypes() {
        return gradeTypeRepository.findAll();
    }
}
