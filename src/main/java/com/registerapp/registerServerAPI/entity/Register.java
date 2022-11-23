package com.registerapp.registerServerAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "register")
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "register_id")
    private Long register_id;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher_id;

    @OneToOne
    @JoinColumn(name = "subject_id")
    private Subject subject_id;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class class_id;

    @Column(name = "is_supervising_teacher")
    private Boolean is_supervising_teacher;

    @JsonIgnore
    @OneToMany(mappedBy = "register_id")
    private List<Grade> grades;

    @JsonIgnore
    @OneToMany(mappedBy = "register_id")
    private List<Schedule> schedules;

    @JsonIgnore
    @OneToMany(mappedBy = "register_id")
    private List<Attendance> attendances;

    public Register(Teacher teacher_id, Subject subject_id, Class class_id, Boolean is_supervising_teacher) {
        this.teacher_id = teacher_id;
        this.subject_id = subject_id;
        this.class_id = class_id;
        this.is_supervising_teacher = is_supervising_teacher;
    }
}
