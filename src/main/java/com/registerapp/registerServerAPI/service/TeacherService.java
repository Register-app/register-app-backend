package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.entity.Teacher;
import com.registerapp.registerServerAPI.payload.response.GetTeacherByUserIdResponse;
import com.registerapp.registerServerAPI.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TeacherService {

    private TeacherRepository teacherRepository;

    public GetTeacherByUserIdResponse getTeacherByUser(Long user_id) {
        Optional<Teacher> teacher = teacherRepository.findByUser(user_id);

        return teacher.map(tch -> mapTeacherToGetTeacherByUserIdResponse(tch)).get();
    }

    private GetTeacherByUserIdResponse mapTeacherToGetTeacherByUserIdResponse(Teacher tch) {
        return GetTeacherByUserIdResponse.builder()
                .teacher_id(tch.getTeacher_id())
                .build();
    }
}
