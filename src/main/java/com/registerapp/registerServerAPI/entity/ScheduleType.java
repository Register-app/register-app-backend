package com.registerapp.registerServerAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "schedule_type")
public class ScheduleType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_type_id")
    private Long schedule_type_id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "schedule_type_id")
    private Set<Schedule> schedules;

    public ScheduleType(String name) {
        this.name = name;
    }
}