package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.entity.Role;
import com.registerapp.registerServerAPI.entity.User;
import com.registerapp.registerServerAPI.repository.RoleRepository;
import com.registerapp.registerServerAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    //private BCryptPasswordEncoder passwordEncoder;

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

    public void init() {
        Role role1 = new Role("ADMIN");
        roleRepository.save(role1);

        Role role2 = new Role("USER");
        roleRepository.save(role2);

        User user1 = new User("Konrad", "Kalman", "test@test.pl", getEncodedPassword("12345"), Set.of(role1));
        userRepository.save(user1);
    }
}
