package com.registerapp.registerServerAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long student_id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class class_id;

    @JsonIgnore
    @OneToMany(mappedBy = "student_id")
    private Set<Grade> grades;

    @JsonIgnore
    @OneToMany(mappedBy = "student_id")
    private Set<Attendance> attendances;

    @JsonIgnore
    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
    private Set<Guardian> guardians;

    public Student(User user_id, Class class_id, Set<Guardian> guardians) {
        this.user_id = user_id;
        this.class_id = class_id;
        this.guardians = guardians;
    }

    public Student(User user_id) {
        this.user_id = user_id;
    }

    public Student(User user_id, Class class_id) {
        this.user_id = user_id;
        this.class_id = class_id;
    }

    public Student(User user_id, Set<Guardian> guardians) {
        this.user_id = user_id;
        this.guardians = guardians;
    }
}
