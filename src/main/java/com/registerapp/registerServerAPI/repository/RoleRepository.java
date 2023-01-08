package com.registerapp.registerServerAPI.repository;

import com.registerapp.registerServerAPI.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query(value = "SELECT * FROM role r WHERE r.name = ?1", nativeQuery = true)
    Role findByName(String name);
}
