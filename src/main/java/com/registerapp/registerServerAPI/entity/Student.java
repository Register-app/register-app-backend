package com.registerapp.registerServerAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long student_id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class class_id;

    @JsonIgnore
    @OneToMany(mappedBy = "student_id")
    private Set<Grade> grades;

    public Student(User user_id) {
        this.user_id = user_id;
    }
}
