package com.registerapp.registerServerAPI.repository;

import com.registerapp.registerServerAPI.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository  extends JpaRepository<Register, Long> {
}