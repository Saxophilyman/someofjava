package ru.saxophilyman.validation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertTrue(errors.contains("Password must be at least 8 characters long"));
    }

    @Test
    void testErrorWhenPasswordIsLong() {
        PasswordValidator validator = new PasswordValidator();
        List<String> errors = validator.validate("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        assertTrue(errors.contains("Password must be no more than 30 characters long"));
    }

    @Test
    void testErrorWhenPasswordIsHaveNotDigit() {
        PasswordValidator validator = new PasswordValidator();
        List<String> errors = validator.validate("abcdefgh");
        assertTrue(errors.contains("Password must contain at least one digit"));
    }

    @Test
    void testSeveralErrorInPassword() {
        PasswordValidator validator = new PasswordValidator();
        List<String> errors = validator.validate("abc");
        assertEquals(List.of(
                "Password must be at least 8 characters long",
                "Password must contain at least one digit",
                "Password must contain at least one uppercase letter",
                "Password must contain at least one special character"
        ), errors);
    }

    @Test
    void testErrorHaveOneUppercaseLetter() {
        PasswordValidator validator = new PasswordValidator();
        List<String> errors = validator.validate("abcdefgh1");
        assertTrue(errors.contains("Password must contain at least one uppercase letter"));
    }

    @Test
    void testErrorHaveOneLowercaseLetter() {
        PasswordValidator validator = new PasswordValidator();
        List<String> errors = validator.validate("ABCDEFGH1");
        assertTrue(errors.contains("Password must contain at least one lowercase letter"));
    }

    @Test
    void testErrorWhenHaveNoSpecialCharacters() {
        PasswordValidator validator = new PasswordValidator();
        List<String> errors = validator.validate("abcdefgH1");
        assertEquals(List.of("Password must contain at least one special character"), errors);
    }

    @Test
    void testErrorWhenPasswordHaveSpaces(){
        PasswordValidator validator = new PasswordValidator();
        List<String> errors = validator.validate("abcdefg H1!");
        assertEquals(List.of("Password must not contain whitespace character"), errors);
    }
}