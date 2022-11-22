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
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long schedule_id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "register_id")
    private Register register_id;

    @ManyToOne
    @JoinColumn(name = "schedule_type_id")
    private ScheduleType schedule_type_id;

    public Schedule(LocalDateTime date, String comment, Register register_id, ScheduleType schedule_type_id) {
        this.date = date;
        this.comment = comment;
        this.register_id = register_id;
        this.schedule_type_id = schedule_type_id;
    }
}
