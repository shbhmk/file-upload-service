package com.example.fileuploadservice.validation;

import com.example.fileuploadservice.dto.RegisterRequest;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Custom annotation to validate password and confirmPassword match
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
public @interface PasswordMatches {
    String message() default "Passwords do not match"; // Custom message

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
