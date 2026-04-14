package ru.saxophilyman.validation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordValidatorTest {

    @Test
    void testErrorWhenPasswordIsnull() {
        PasswordValidator validator = new PasswordValidator();

        List<String> errors = validator.validate(null);
        assertEquals(List.of("Password must not be null"), errors);
    }

    @Test
    void testErrorWhenPasswordIsEmpty() {
        PasswordValidator validator = new PasswordValidator();
        List<String> errors = validator.validate("");
        assertEquals(List.of("Password must not be empty"), errors);
    }
}
