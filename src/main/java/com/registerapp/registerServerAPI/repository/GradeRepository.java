package com.registerapp.registerServerAPI.repository;

import com.registerapp.registerServerAPI.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository  extends JpaRepository<Grade, Long> {
}