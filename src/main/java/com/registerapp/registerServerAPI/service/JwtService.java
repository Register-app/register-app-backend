package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.entity.User;
import com.registerapp.registerServerAPI.payload.JwtRequest;
import com.registerapp.registerServerAPI.payload.JwtResponse;
import com.registerapp.registerServerAPI.repository.UserRepository;
import com.registerapp.registerServerAPI.service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String email = jwtRequest.getEmail();
        String password = jwtRequest.getPassword();
        authenticate(email, password);

        final UserDetails userDetails = loadUserByUsername(email);

        String newGeneratedToken = jwtUtil.generateToken(userDetails);

        User user = userRepository.findByEmail(email);

        return new JwtResponse(user, newGeneratedToken);
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(userEmail);

        if(user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    getAuthorities(user)
            );
        } else {
            throw new UsernameNotFoundException("Email jest nieprawidłowy.");
        }
    }

    private void authenticate(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("Użytkownik jest dezaktywowany.");
        } catch (BadCredentialsException e) {
            throw new Exception("Podano złe dane od użytkownika.");
        }
    }

    private Set getAuthorities(User user) {
        Set authorities = new HashSet<>();

        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
        });

        return authorities;
    }
}
