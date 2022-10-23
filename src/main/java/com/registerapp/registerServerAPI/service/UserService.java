package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.model.User;
import com.registerapp.registerServerAPI.dto.UserRegistrationDto;

public interface UserService {
    User save(UserRegistrationDto userRegistrationDto);
}
