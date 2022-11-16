package com.registerapp.registerServerAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "class")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Long class_id;

    @Column(name = "name")
    private String name;

    @Column(name = "school_year")
    private String school_year;

    @JsonIgnore
    @OneToMany(mappedBy="class_id")
    private List<Student> students;

    @JsonIgnore
    @OneToMany(mappedBy="class_id")
    private List<Register> registers;

    public Class(String name, String school_year) {
        this.name = name;
        this.school_year = school_year;
    }
}
