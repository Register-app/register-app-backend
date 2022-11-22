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
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long attendance_id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student_id;

    @ManyToOne
    @JoinColumn(name = "register_id")
    private Register register_id;

    public Attendance(LocalDateTime date, String type, Student student_id, Register register_id) {
        this.date = date;
        this.type = type;
        this.student_id = student_id;
        this.register_id = register_id;
    }
}
