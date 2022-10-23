package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.model.Role;
import com.registerapp.registerServerAPI.model.User;
import com.registerapp.registerServerAPI.repository.UserRepository;
import com.registerapp.registerServerAPI.dto.UserRegistrationDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
        User user = new User(
                userRegistrationDto.getName(),
                userRegistrationDto.getSurname(),
                userRegistrationDto.getEmail(),
                userRegistrationDto.getPassword(),
                Arrays.asList(new Role("ROLE_USER"))
                );
        return userRepository.save(user);
    }
}
