package com.example.fileuploadservice.service;

import com.example.fileuploadservice.dto.LoginRequest;
import com.example.fileuploadservice.exception.InvalidCredentialsException;
import com.example.fileuploadservice.exception.UserAlreadyExistsException;
import com.example.fileuploadservice.model.User;
import com.example.fileuploadservice.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public boolean authenticate(LoginRequest loginRequest){

        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new UserAlreadyExistsException("Email does not exist"));


        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            throw new InvalidCredentialsException("Invalid credentials");
        }

        return passwordEncoder.matches(loginRequest.getPassword(),user.getPassword());

    }
}
