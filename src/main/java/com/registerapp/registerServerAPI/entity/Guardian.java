package com.registerapp.registerServerAPI.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "guardian")
public class Guardian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guardian_id")
    private Long guardian_id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "guardian_has_student",
            joinColumns = @JoinColumn(
                    name = "guardian_id", referencedColumnName = "guardian_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id", referencedColumnName = "student_id"
            )
    )
    private Set<Student> students;

    public Guardian(User user_id) {
        this.user_id = user_id;
    }
}
