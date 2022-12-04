package com.registerapp.registerServerAPI.repository;

import com.registerapp.registerServerAPI.entity.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuardianRepository  extends JpaRepository<Guardian, Long> {

    @Query(value = "SELECT * FROM guardian g WHERE g.user_id = ?1", nativeQuery = true)
    Optional<Guardian> findByUser_id(Long user_id);
}