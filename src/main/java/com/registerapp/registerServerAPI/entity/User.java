package com.registerapp.registerServerAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(name = "name")
    private String name;

    @Column(name = "second_name")
    private String second_name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "teacher_id")
    private Long teacher_id;

    @Column(name = "guardian_id")
    private Long guardian_id;

    @Column(name = "student_id")
    private Long student_id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_has_role",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "user_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "role_id"
            )
    )
    private Set<Role> roles;

    public User(String name, String second_name, String email, String password, Set<Role> roles) {
        this.name = name;
        this.second_name = second_name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
