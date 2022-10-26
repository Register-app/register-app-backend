package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.entity.Role;
import com.registerapp.registerServerAPI.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleService {

    private RoleRepository roleRepository;

    public Role createNewRole(Role role) {
        return roleRepository.save(role);
    }
}
