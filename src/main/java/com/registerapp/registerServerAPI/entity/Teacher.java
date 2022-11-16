package com.registerapp.registerServerAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long teacher_id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher_id")
    private Set<Register> registers;

    public Teacher(User user_id) {
        this.user_id = user_id;
    }

}
