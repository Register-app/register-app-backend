package com.registerapp.registerServerAPI.controller;

import com.registerapp.registerServerAPI.entity.Role;
import com.registerapp.registerServerAPI.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class RoleController {

    private RoleService roleService;

//    @PostMapping({"/createNewRole"})
//    public Role createNewRole(@RequestBody Role role) {
//        return roleService.createNewRole(role);
//    }
}
