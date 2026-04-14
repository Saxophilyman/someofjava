package ru.saxophilyman.validation;

import java.util.Optional;

public interface PasswordRules {
    Optional<String> validate(String password);
}
