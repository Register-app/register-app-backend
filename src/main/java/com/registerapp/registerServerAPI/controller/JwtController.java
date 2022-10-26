package com.registerapp.registerServerAPI.controller;

import com.registerapp.registerServerAPI.payload.JwtRequest;
import com.registerapp.registerServerAPI.payload.JwtResponse;
import com.registerapp.registerServerAPI.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@CrossOrigin
public class JwtController {

    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
}
