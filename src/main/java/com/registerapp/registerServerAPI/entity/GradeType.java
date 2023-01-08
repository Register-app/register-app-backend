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
@Builder
@Table(name = "grade_type")
public class GradeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_type_id")
    private Long grade_type_id;

    @Column(name = "value")
    private String value;

    @Column(name = "text")
    private String text;

    @JsonIgnore
    @OneToMany(mappedBy = "grade_type_id")
    private Set<Grade> grades;

    public GradeType(String value, String text) {
        this.value = value;
        this.text = text;
    }
}
