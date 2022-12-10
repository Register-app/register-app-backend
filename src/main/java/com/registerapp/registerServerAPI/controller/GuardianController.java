package com.registerapp.registerServerAPI.controller;

import com.registerapp.registerServerAPI.service.GuardianService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/guardians")
public class GuardianController {

    private GuardianService guardianService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> getGuardians() throws Exception {
        return ResponseEntity.ok(guardianService.getGuardians());
    }
}
