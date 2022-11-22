package com.registerapp.registerServerAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "grade_value")
public class GradeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_value_id")
    private Long grade_value_id;

    @Column(name = "value")
    private Float value;

    @Column(name = "text")
    private String text;

    @JsonIgnore
    @OneToMany(mappedBy = "grade_value_id")
    private List<Grade> grades;

    public GradeValue(Float value, String text) {
        this.value = value;
        this.text = text;
    }
}
