package com.registerapp.registerServerAPI.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private Long grade_id;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student_id;

    @ManyToOne
    @JoinColumn(name = "register_id")
    private Register register_id;

    @ManyToOne
    @JoinColumn(name = "grade_type_id")
    private GradeType grade_type_id;

    @ManyToOne
    @JoinColumn(name = "grade_value_id")
    private GradeValue grade_value_id;

    public Grade(Integer weight, String comment, LocalDateTime date, Student student_id, Register register_id, GradeType grade_type_id, GradeValue grade_value_id) {
        this.weight = weight;
        this.comment = comment;
        this.date = date;
        this.student_id = student_id;
        this.register_id = register_id;
        this.grade_type_id = grade_type_id;
        this.grade_value_id = grade_value_id;
    }
}
