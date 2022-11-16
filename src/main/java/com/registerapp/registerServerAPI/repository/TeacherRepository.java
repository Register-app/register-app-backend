package com.registerapp.registerServerAPI.repository;

import com.registerapp.registerServerAPI.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository  extends JpaRepository<Teacher, Long> {
}