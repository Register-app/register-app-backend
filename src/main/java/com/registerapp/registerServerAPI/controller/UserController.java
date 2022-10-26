package com.registerapp.registerServerAPI.controller;

import com.registerapp.registerServerAPI.entity.User;
import com.registerapp.registerServerAPI.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@AllArgsConstructor
@RestController
public class UserController {

    private UserService userService;

//    @PostMapping
//    public ResponseEntity<?> registerUserAccount(@RequestBody UserRegistrationDto registrationDto){
//        userService.save(registrationDto);
//        return ResponseEntity.ok("User registered successfully!");
//    }

    @PostConstruct
    public void init(){
        userService.init();
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user){
        return userService.registerNewUser(user);
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('ADMIN')")
    public String forAdmin(){
        return "ADMIN SCREEN";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('USER')")
    public String forUser(){
        return "USER SCREEN";
    }
}
