package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.entity.*;
import com.registerapp.registerServerAPI.payload.request.GradeUpdateRequest;
import com.registerapp.registerServerAPI.payload.request.UserAddRequest;
import com.registerapp.registerServerAPI.payload.request.UserUpdateRequest;
import com.registerapp.registerServerAPI.payload.response.UserAddResponse;
import com.registerapp.registerServerAPI.repository.RoleRepository;
import com.registerapp.registerServerAPI.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
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

    public UserAddResponse addUser(UserAddRequest userAddRequest) {
        User userByEmail = userRepository.findByEmail(userAddRequest.getEmail());
        if(userByEmail != null){
            throw new IllegalStateException("Email zajęty!");
        }

        Role role = roleRepository.findByName("USER");

        User user = userRepository.save(new User(
                userAddRequest.getName(),
                userAddRequest.getSecond_name(),
                userAddRequest.getEmail(),
                passwordEncoder.encode(userAddRequest.getPassword()),
                Set.of( role )
                ));

        return UserAddResponse.builder()
                .user_id(user.getUser_id())
                .name(user.getName())
                .second_name(user.getSecond_name())
                .email(user.getEmail())
                .build();
    }

    public void deleteUser(Long user_id) {
        boolean exists = userRepository.existsById(user_id);
        if(!exists){
            throw new IllegalStateException("Użytkownik o id " + user_id + " nie istnieje.");
        }
        userRepository.deleteById(user_id);
    }

    public void updateUser(UserUpdateRequest userUpdateRequest) {
        User user = userRepository.findById(userUpdateRequest.getUser_id()).orElseThrow(() -> new IllegalStateException("Użytkownik o id " + userUpdateRequest.getUser_id() + " nie istnieje."));

        if(userUpdateRequest.getName() != null
                && userUpdateRequest.getName() != ""
                && !Objects.equals(user.getName(), userUpdateRequest.getName())) {
            user.setName(userUpdateRequest.getName());
        }

        if(userUpdateRequest.getSecond_name() != null
                && userUpdateRequest.getSecond_name() != ""
                && !Objects.equals(user.getSecond_name(), userUpdateRequest.getSecond_name())) {
            user.setSecond_name(userUpdateRequest.getSecond_name());
        }

        if(userUpdateRequest.getEmail() != null
                && userUpdateRequest.getEmail() != ""
                && !Objects.equals(user.getEmail(), userUpdateRequest.getEmail())) {
            user.setEmail(userUpdateRequest.getEmail());
        }

        if(userUpdateRequest.getPassword() != null
                && userUpdateRequest.getPassword() != ""
                && !passwordEncoder.matches(userUpdateRequest.getPassword(), user.getPassword())) {
            user.setPassword(passwordEncoder.encode(userUpdateRequest.getPassword()));
        }

        userRepository.save(user);
    }
}
