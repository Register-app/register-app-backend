package com.registerapp.registerServerAPI.controller;

import com.registerapp.registerServerAPI.dto.UserRegistrationDto;
import com.registerapp.registerServerAPI.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/registration")
@CrossOrigin(origins = "*")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> registerUserAccount(@RequestBody UserRegistrationDto registrationDto){
        userService.save(registrationDto);
        return ResponseEntity.ok("User registered successfully!");
    }
}
