package com.example.norcomapllication.model.validate;

import com.example.norcomapllication.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidateUniqueUsername implements ConstraintValidator<UniqueUsername, String> {
    private final UserService userService;

    public ValidateUniqueUsername(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if(username == null) {
            return true;
        }
        return userService.isFreeUsername(username);
    }
}
