package com.registerapp.registerServerAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private Long grade_id;

    @Column(name = "text")
    private String text;

    @Column(name = "value")
    private Float value;

    @Column(name = "weight")
    private Number weight;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date_time")
    private LocalDateTime date_time;

    @Column(name = "category")
    private String category;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student_id;

    @ManyToOne
    @JoinColumn(name = "register_id")
    private Register register_id;
}
