package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.entity.Student;
import com.registerapp.registerServerAPI.entity.Teacher;
import com.registerapp.registerServerAPI.payload.response.GetTeacherByUserResponse;
import com.registerapp.registerServerAPI.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class TeacherService {

    private TeacherRepository teacherRepository;

    public GetTeacherByUserResponse getTeacherByUser(Long user_id) {
        Teacher teacher = teacherRepository.findByUser(user_id).orElseThrow(() -> new IllegalStateException("Nauczyciel o id urzytkownika " + user_id + " nie istnieje."));

        return GetTeacherByUserResponse.builder()
                .teacher_id(teacher.getTeacher_id())
                .build();
    }
//    public Teacher getSingleTeacher(Long id) {
//        return teacherRepository.findById(id).orElseThrow();
//    }
//

}
