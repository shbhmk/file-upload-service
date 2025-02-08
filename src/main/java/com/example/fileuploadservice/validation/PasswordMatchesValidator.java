package com.example.fileuploadservice.validation;

import com.example.fileuploadservice.dto.RegisterRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, RegisterRequest> {
    @Override
    public boolean isValid(RegisterRequest registerRequest , ConstraintValidatorContext context){
        return registerRequest.getPassword().equals(registerRequest.getConfirmPassword());
    }
}
