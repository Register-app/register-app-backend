package com.registerapp.registerServerAPI.controller;

import com.registerapp.registerServerAPI.payload.request.LoginRequest;
import com.registerapp.registerServerAPI.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class JwtController {

    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) throws Exception {
        return ResponseEntity.ok(jwtService.createJwtToken(loginRequest));
    }
}
