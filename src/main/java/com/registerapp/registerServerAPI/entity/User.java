package com.registerapp.registerServerAPI.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;
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
    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "name")
    private String name;

    @Column(name = "second_name")
    private String second_name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
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

    @JsonIgnore
    @OneToMany(mappedBy="sender_id")
    private Set<Message> messages;

    @JsonIgnore
    @OneToOne(mappedBy="user_id")
    private Student student;

    @JsonIgnore
    @OneToOne(mappedBy="user_id")
    private Guardian guardian;

    @JsonIgnore
    @OneToOne(mappedBy="user_id")
    private Teacher teacher;


    public User(Long user_id, String name, String second_name, String email, String password, Set<Role> roles) {
        this.user_id = user_id;
        this.name = name;
        this.second_name = second_name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User(String name, String second_name, String email, String password, Set<Role> roles) {
        this.name = name;
        this.second_name = second_name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
