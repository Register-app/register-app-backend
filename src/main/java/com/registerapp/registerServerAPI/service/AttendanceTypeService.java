package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.entity.AttendanceType;
import com.registerapp.registerServerAPI.repository.AttendanceTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class AttendanceTypeService {
    private AttendanceTypeRepository attendanceTypeRepository;
        public List<AttendanceType> getAllAttendanceTypes() {
            return attendanceTypeRepository.findAll();
  }
}
