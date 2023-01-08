package com.registerapp.registerServerAPI.controller;

import com.registerapp.registerServerAPI.entity.User;
import com.registerapp.registerServerAPI.payload.request.UserAddRequest;
import com.registerapp.registerServerAPI.payload.request.UserUpdateRequest;
import com.registerapp.registerServerAPI.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    @PostMapping("/user")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> addUser(@RequestBody UserAddRequest userAddRequest){
        return ResponseEntity.ok(userService.addUser(userAddRequest));
    }
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<?> getAllUsers() throws Exception {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/user/{user_id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> deleteUser(@PathVariable Long user_id) throws Exception {
        userService.deleteUser(user_id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/user")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> updateUser(@RequestBody UserUpdateRequest userUpdateRequest) throws Exception {
        userService.updateUser(userUpdateRequest);
        return ResponseEntity.noContent().build();
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
