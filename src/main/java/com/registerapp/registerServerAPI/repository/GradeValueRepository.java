package com.registerapp.registerServerAPI.repository;

import com.registerapp.registerServerAPI.entity.GradeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeValueRepository extends JpaRepository<GradeValue, Long> {
}
