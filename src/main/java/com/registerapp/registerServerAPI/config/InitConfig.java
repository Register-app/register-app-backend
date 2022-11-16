package com.registerapp.registerServerAPI.config;

import com.registerapp.registerServerAPI.entity.*;
import com.registerapp.registerServerAPI.entity.Class;
import com.registerapp.registerServerAPI.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Configuration
public class InitConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository,
                                        RoleRepository roleRepository,
                                        PasswordEncoder passwordEncoder,
                                        MessageRepository messageRepository,
                                        ClassRepository classRepository,
                                        GradeRepository gradeRepository,
                                        GuardianRepository guardianRepository,
                                        RegisterRepository registerRepository,
                                        StudentRepository studentRepository,
                                        SubjectRepository subjectRepository,
                                        TeacherRepository teacherRepository){
        return args -> {

            Role role1 = new Role(
                    "ADMIN"
            );

            Role role2 = new Role(
                    "USER"
            );

            Role role3 = new Role(
                    "TEACHER"
            );

            Role role4 = new Role(
                    "GUARDIAN"
            );

            Role role5 = new Role(
                    "STUDENT"
            );

            roleRepository.saveAll(
                    List.of(role1, role2, role3, role4, role5)
            );

            User user1 = new User(
                    "admin",
                    "admin",
                    "admin@admin.pl",
                    passwordEncoder.encode("12345"),
                    Set.of(role1)
            );

            User user2 = new User(
                    "user",
                    "user",
                    "user@user.pl",
                    passwordEncoder.encode("12345"),
                    Set.of(role2)
            );

            User user3 = new User(
                    "teacher",
                    "teacher",
                    "teacher@teacher.pl",
                    passwordEncoder.encode("12345"),
                    Set.of(role3, role2)
            );

            User user4 = new User(
                    "guardian",
                    "guardian",
                    "guardian@guardian.pl",
                    passwordEncoder.encode("12345"),
                    Set.of(role4, role2)
            );

            User user5 = new User(
                    "student",
                    "student",
                    "student@student.pl",
                    passwordEncoder.encode("12345"),
                    Set.of(role5, role2)
            );

            userRepository.saveAll(
                    List.of(user1, user2, user3, user4, user5)
            );

            Message message1 = new Message(
                    "TEST",
                    LocalTime.now(),
                    LocalDate.now(),
                    user1,
                    2L
            );

            Message message2 = new Message(
                    "TEST",
                    LocalTime.now(),
                    LocalDate.now(),
                    user2,
                    3L
            );

            Message message3 = new Message(
                    "TEST",
                    LocalTime.now(),
                    LocalDate.now(),
                    user2,
                    1L
            );

            Message message4 = new Message(
                    "TEST",
                    LocalTime.now(),
                    LocalDate.now(),
                    user3,
                    2L
            );

            Message message5 = new Message(
                    "TEST",
                    LocalTime.now(),
                    LocalDate.now(),
                    user3,
                    1L
            );

            Message message6 = new Message(
                    "TEST",
                    LocalTime.now(),
                    LocalDate.now(),
                    user1,
                    4L
            );

            messageRepository.saveAll(
                    List.of(message1, message2, message3, message4, message5, message6)
            );

            Teacher teacher1 = new Teacher(user3);

            teacherRepository.saveAll(
                    List.of(teacher1)
            );

            Student student1 = new Student(user5);

            studentRepository.saveAll(
                    List.of(student1)
            );

            Guardian guardian1 = new Guardian(user4);

            guardianRepository.saveAll(
                    List.of(guardian1)
            );

            Class class1 = new Class(
                    "III A",
                    "2022/2023"
            );

            classRepository.saveAll(
                    List.of(class1)
            );

            student1.setClass_id(class1);

            studentRepository.save(student1);
        };
    }
}
