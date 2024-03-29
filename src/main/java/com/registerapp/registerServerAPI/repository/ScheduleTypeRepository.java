package com.registerapp.registerServerAPI.repository;

import com.registerapp.registerServerAPI.entity.ScheduleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleTypeRepository extends JpaRepository<ScheduleType, Long> {
}
