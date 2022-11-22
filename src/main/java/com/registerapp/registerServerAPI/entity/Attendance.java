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

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student_id;

    @ManyToOne
    @JoinColumn(name = "register_id")
    private Register register_id;

    @ManyToOne
    @JoinColumn(name = "attendance_type_id")
    private AttendanceType attendance_type_id;

    public Attendance(LocalDateTime date, Student student_id, Register register_id, AttendanceType attendance_type_id) {
        this.date = date;
        this.student_id = student_id;
        this.register_id = register_id;
        this.attendance_type_id = attendance_type_id;
    }
}
