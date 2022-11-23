package com.registerapp.registerServerAPI.repository;

import com.registerapp.registerServerAPI.entity.Attendance;
import com.registerapp.registerServerAPI.entity.AttendanceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceTypeRepository extends JpaRepository<AttendanceType, Long> {

}
