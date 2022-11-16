package com.registerapp.registerServerAPI.repository;

import com.registerapp.registerServerAPI.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository  extends JpaRepository<Class, Long> {
}
