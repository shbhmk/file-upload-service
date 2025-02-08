package com.example.fileuploadservice.service;

import com.example.fileuploadservice.dto.RegisterRequest;
import com.example.fileuploadservice.exception.UserAlreadyExistsException;
import com.example.fileuploadservice.model.User;
import com.example.fileuploadservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private  final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    public UserService(UserRepository userRepository , PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(RegisterRequest request){
        try {
            if (userRepository.existsByUsername(request.getUsername())) {
                throw new UserAlreadyExistsException("Username already exists");
            }
            if (userRepository.existsByEmail(request.getEmail())) {
                throw new UserAlreadyExistsException("Email already registered");

            }
            User user = new User();
            user.setUsername(request.getUsername());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setEmail(request.getEmail());
            return userRepository.save(user);
        }catch(Exception e){
            logger.error("Error registering user",e);
            throw new RuntimeException("Failed to register user");
        }


    }
    public List<User> getAllUsers(){
        return userRepository.findAll();

    }



}
