package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.entity.Role;
import com.registerapp.registerServerAPI.entity.User;
import com.registerapp.registerServerAPI.repository.RoleRepository;
import com.registerapp.registerServerAPI.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
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

//    public void init() {
//        Role role1 = new Role(1L, "ADMIN");
//        roleRepository.save(role1);
//
//        Role role2 = new Role(2L, "USER");
//        roleRepository.save(role2);
//
//        User user1 = new User(1L,"Konrad", "Kalman", "konrad@kal.pl", getEncodedPassword("12345"), Set.of(role1));
//        userRepository.save(user1);
//
//        User user2 = new User(2L,"Kacper", "Kasiński", "kacper@kas.pl", getEncodedPassword("12345"), Set.of(role2));
//        userRepository.save(user2);
//    }
}
