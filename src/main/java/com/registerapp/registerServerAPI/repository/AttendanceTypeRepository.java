package com.registerapp.registerServerAPI.repository;

import com.registerapp.registerServerAPI.entity.AttendanceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceTypeRepository extends JpaRepository<AttendanceType, Long> {
}
