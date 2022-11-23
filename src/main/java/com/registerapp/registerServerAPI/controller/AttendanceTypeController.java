package com.registerapp.registerServerAPI.controller;

import com.registerapp.registerServerAPI.entity.AttendanceType;
import com.registerapp.registerServerAPI.service.AttendanceService;
import com.registerapp.registerServerAPI.service.AttendanceTypeService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/attendancetype")
public class AttendanceTypeController {
private AttendanceTypeService attendanceTypeService;

    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<AttendanceType> getAllAttendanceTypes(){
        return attendanceTypeService.getAllAttendanceTypes();
    }
}
