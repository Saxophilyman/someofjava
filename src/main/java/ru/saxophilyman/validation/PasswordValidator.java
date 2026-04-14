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

        List<String> errors = new ArrayList<>();
        //short
        if (password.length() < 8) {
            errors.add("Password must be at least 8 characters long");
        }
        //long
        if (password.length() > 30) {
            errors.add("Password must be no more than 30 characters long");
        }
        //one digit
        if (password.chars().noneMatch(Character::isDigit)){
            errors.add("Password must contain at least one digit");
        }
        //one upperCase
        if (password.chars().noneMatch(Character::isUpperCase)){
            errors.add("Password must contain at least one uppercase letter");
        }
        //one lowercase
        if (password.chars().noneMatch(Character::isLowerCase)){
            errors.add("Password must contain at least one lowercase letter");
        }
        //special characters
        if (password.chars().allMatch(Character::isLetterOrDigit)){
            errors.add("Password must contain at least one special character");
        }
        //no space
//        if (!password.chars().noneMatch(Character::isSpaceChar)){
//            errors.add("Password must not contain space character");
//        }
        return errors;
    }
}
