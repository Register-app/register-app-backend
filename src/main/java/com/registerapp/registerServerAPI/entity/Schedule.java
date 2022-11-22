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

    @Column(name = "type")
    private String type;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "register_id")
    private Register register_id;

    public Schedule(String type, LocalDateTime date, String comment, Register register_id) {
        this.type = type;
        this.date = date;
        this.comment = comment;
        this.register_id = register_id;
    }
}
