package com.registerapp.registerServerAPI.repository;

import com.registerapp.registerServerAPI.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository  extends JpaRepository<Subject, Long> {
}