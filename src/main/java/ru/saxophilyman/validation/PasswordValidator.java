package ru.saxophilyman.validation;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {
    public List<String> validate(String password) {
        //null
        if (password == null) {
            return List.of("Password must not be null");
        }
        List<String> errors = new ArrayList<>();
        //empty
        if (password.isEmpty()) {
            errors.add("Password must not be empty");
        }
        //short
        if (password.length() < 8) {
            errors.add("Password must be at least 8 characters long");
        }
        if (password.length() > 30) {
            errors.add("Password must be no more than 30 characters long");
        }
        //one digit
        if (password.chars().noneMatch(Character::isDigit)){
            errors.add("Password must contain at least one digit");
        }
        return errors;
    }
}
