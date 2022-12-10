package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.entity.Class;
import com.registerapp.registerServerAPI.entity.Guardian;
import com.registerapp.registerServerAPI.payload.response.GuardianGetResponse;
import com.registerapp.registerServerAPI.repository.GuardianRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GuardianService {

    private GuardianRepository guardianRepository;

    public List<GuardianGetResponse> getGuardians() {
        List<Guardian> guardians = guardianRepository.findAll();
        return guardians.stream().map(guardian -> mapToGuardianGetResponse(guardian))
                .sorted(Comparator.comparing(GuardianGetResponse::getSecond_name))
                .collect(Collectors.toList());
    }

    private GuardianGetResponse mapToGuardianGetResponse(Guardian guardian) {
        return GuardianGetResponse.builder()
                .user_id(guardian.getUser_id().getUser_id())
                .guardian_id(guardian.getGuardian_id())
                .name(guardian.getUser_id().getName())
                .second_name(guardian.getUser_id().getSecond_name())
                .student_id(guardian.getStudents().stream().map(std -> std.getStudent_id()).collect(Collectors.toList()))
                .email(guardian.getUser_id().getEmail())
                .build();
    }
}
