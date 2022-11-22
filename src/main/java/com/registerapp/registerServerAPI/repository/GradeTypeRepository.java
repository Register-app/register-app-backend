package com.registerapp.registerServerAPI.repository;

import com.registerapp.registerServerAPI.entity.GradeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeTypeRepository extends JpaRepository<GradeType, Long> {
}
