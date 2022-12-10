package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.entity.User;
import com.registerapp.registerServerAPI.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

//    public User save(UserRegistrationDto userRegistrationDto) {
//        User user = new User(
//                userRegistrationDto.getName(),
//                userRegistrationDto.getSecond_name(),
//                userRegistrationDto.getEmail(),
//                passwordEncoder.encode(userRegistrationDto.getPassword()),
//                Arrays.asList(new Role("ROLE_USER"))
//        );
//
//        return userRepository.save(user);
//    }


    public User registerNewUser(User user) {
        return userRepository.save(user);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().sorted(Comparator.comparing(User::getSecond_name))
                .collect(Collectors.toList());
    }
}
