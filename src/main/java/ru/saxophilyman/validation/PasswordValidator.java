package ru.saxophilyman.validation;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {
    public List<String> validate(String password) {
        //null
        if (password == null) {
            return List.of("Password must not be null");
        }
        //empty
        if (password.isEmpty()) {
            return List.of("Password must not be empty");
        }
        //short
        if (password.length() < 8) {
            return List.of("Password must be at least 8 characters long");
        }
        return List.of();
    }
}
