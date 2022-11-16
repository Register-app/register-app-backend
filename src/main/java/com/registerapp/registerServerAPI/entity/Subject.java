package com.registerapp.registerServerAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long subject_id;

    @Column(name = "name")
    private String name;

    @Column(name = "day")
    private String day;

    @Column(name = "time")
    private LocalTime time;

    @JsonIgnore
    @OneToOne(mappedBy = "subject_id")
    private Register register;

    public Subject(String name, String day, LocalTime time) {
        this.name = name;
        this.day = day;
        this.time = time;
    }
}
