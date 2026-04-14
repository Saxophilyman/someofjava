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

    @Test
    void testErrorWhenPasswordIsShort() {
        PasswordValidator validator = new PasswordValidator();
        List<String> errors = validator.validate("abc");
        assertEquals(List.of("Password must be at least 8 characters long"), errors);
    }

    @Test
    void testErrorWhenPasswordIsLong() {
        PasswordValidator validator = new PasswordValidator();
        List<String> errors = validator.validate("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        assertEquals(List.of("Password must be no more than 30 characters long"), errors);
    }

    @Test
    void testErrorWhenPasswordIsHaveNotDigit() {
        PasswordValidator validator = new PasswordValidator();
        List<String> errors = validator.validate("abcdefgh");
        assertEquals(List.of("Password must contain at least one digit"), errors);
    }

    @Test
    void testSeveralErrorInPassword() {
        PasswordValidator validator = new PasswordValidator();
        List<String> errors = validator.validate("abc");
        assertEquals(List.of(
                "Password must be at least 8 characters long",
                "Password must contain at least one digit",
                "Password must contain at least one uppercase letter"
        ), errors);
    }

    @Test
    void testErrorHaveOneUppercaseLetter() {
        PasswordValidator validator = new PasswordValidator();
        List<String> errors = validator.validate("abcdefgh1");
        assertEquals(List.of("Password must contain at least one uppercase letter"), errors);
    }
}