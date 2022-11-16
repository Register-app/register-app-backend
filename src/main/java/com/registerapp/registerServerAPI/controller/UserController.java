package com.registerapp.registerServerAPI.controller;

import com.registerapp.registerServerAPI.entity.User;
import com.registerapp.registerServerAPI.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

//    @PostMapping
//    public ResponseEntity<?> registerUserAccount(@RequestBody UserRegistrationDto registrationDto){
//        userService.save(registrationDto);
//        return ResponseEntity.ok("User registered successfully!");
//    }
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

//    @PostMapping({"/registerNewUser"})
//    public User registerNewUser(@RequestBody User user){
//        return userService.registerNewUser(user);
//    }
//
//    @GetMapping({"/forAdmin"})
//    @PreAuthorize("hasRole('ADMIN')")
//    public String forAdmin(){
//        return "ADMIN SCREEN";
//    }
//
//    @GetMapping({"/forUser"})
//    @PreAuthorize("hasRole('USER')")
//    //@PreAuthorize("hasAnyRole('USER','ADMIN')")
//    public String forUser(){
//        return "USER SCREEN";
//    }
}
