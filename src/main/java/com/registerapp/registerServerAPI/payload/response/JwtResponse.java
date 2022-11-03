package com.registerapp.registerServerAPI.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.registerapp.registerServerAPI.entity.Role;
import com.registerapp.registerServerAPI.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class JwtResponse {
    private Long user_id;
    private String name;
    private String second_name;
    private String email;
    private Long teacher_id;
    private Long guardian_id;
    private Long student_id;
    private Set<Role> roles;
    private String jwtToken;
}
