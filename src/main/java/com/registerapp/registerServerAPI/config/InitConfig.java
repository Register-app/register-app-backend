package com.registerapp.registerServerAPI.config;

import com.registerapp.registerServerAPI.entity.Message;
import com.registerapp.registerServerAPI.entity.Role;
import com.registerapp.registerServerAPI.entity.User;
import com.registerapp.registerServerAPI.repository.MessageRepository;
import com.registerapp.registerServerAPI.repository.RoleRepository;
import com.registerapp.registerServerAPI.repository.UserRepository;
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
    CommandLineRunner commandLineRunner(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, MessageRepository messageRepository){
        return args -> {

            Role role1 = new Role(
                    1L,
                    "ADMIN"
            );

            Role role2 = new Role(
                    2L,
                    "USER"
            );

            Role role3 = new Role(
                    3L,
                    "TEACHER"
            );

            Role role4 = new Role(
                    4L,
                    "GUARDIAN"
            );

            Role role5 = new Role(
                    5L,
                    "STUDENT"
            );

            roleRepository.saveAll(
                    List.of(role1, role2, role3, role4, role5)
            );

            User user1 = new User(
                    1L,
                    "admin",
                    "admin",
                    "admin@admin.pl",
                    passwordEncoder.encode("12345"),
                    Set.of(role1, role2)
            );

            User user2 = new User(
                    2L,
                    "user",
                    "user",
                    "user@user.pl",
                    passwordEncoder.encode("12345"),
                    Set.of(role2)
            );

            User user3 = new User(
                    3L,
                    "teacher",
                    "teacher",
                    "teacher@teacher.pl",
                    passwordEncoder.encode("12345"),
                    Set.of(role3, role2)
            );

            User user4 = new User(
                    4L,
                    "guardian",
                    "guardian",
                    "guardian@guardian.pl",
                    passwordEncoder.encode("12345"),
                    Set.of(role4, role2)
            );

            User user5 = new User(
                    5L,
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
                    1L,
                    "TEST",
                    LocalTime.now(),
                    LocalDate.now(),
                    user1,
                    2L
            );

            Message message2 = new Message(
                    2L,
                    "TEST",
                    LocalTime.now(),
                    LocalDate.now(),
                    user2,
                    3L
            );

            Message message3 = new Message(
                    3L,
                    "TEST",
                    LocalTime.now(),
                    LocalDate.now(),
                    user2,
                    1L
            );

            Message message4 = new Message(
                    4L,
                    "TEST",
                    LocalTime.now(),
                    LocalDate.now(),
                    user3,
                    2L
            );

            Message message5 = new Message(
                    5L,
                    "TEST",
                    LocalTime.now(),
                    LocalDate.now(),
                    user3,
                    1L
            );

            Message message6 = new Message(
                    6L,
                    "TEST",
                    LocalTime.now(),
                    LocalDate.now(),
                    user1,
                    4L
            );

            messageRepository.saveAll(
                    List.of(message1, message2, message3, message4, message5, message6)
            );
        };
    }
}
