package com.example.fileuploadservice.controller;

import com.example.fileuploadservice.dto.LoginRequest;
import com.example.fileuploadservice.dto.RegisterRequest;
import com.example.fileuploadservice.service.AuthService;
import com.example.fileuploadservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final  UserService userService;
    private final AuthService authService;
    public AuthController(UserService userService,AuthService authService){
        this.userService =userService;
        this.authService= authService;
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request){
        userService.registerUser(request);
        return ResponseEntity.ok("User registered Successfull");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest loginRequest){
        authService.authenticate(loginRequest);
        return ResponseEntity.ok("Login succesfull");
    }
}
