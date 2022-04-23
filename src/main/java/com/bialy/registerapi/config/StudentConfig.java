package com.bialy.registerapi.config;

import com.bialy.registerapi.model.Student;
import com.bialy.registerapi.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student konrad = new Student(
                    1L,
                    "Konrad",
                    "Kalman",
                    LocalDate.of(1999, Month.FEBRUARY, 19)
            );

            Student kacper = new Student(
                    2L,
                    "Kacper",
                    "Karpinski",
                    LocalDate.of(2000, Month.MARCH, 16)
            );

            repository.saveAll(
                    List.of(konrad, kacper)
            );
        };
    }
}
