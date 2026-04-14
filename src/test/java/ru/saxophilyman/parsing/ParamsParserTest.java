package ru.saxophilyman.parsing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParamsParserTest {

    @Test
    void testExceptionWhenInputNull(){
        ParamsParser parser = new ParamsParser();
        assertThrows(IllegalArgumentException.class, () -> parser.parse(null));
    }

    @Test
    void testEmptyWhenInputEmpty(){
        ParamsParser parser = new ParamsParser();
        var result = parser.parse("");

        assertTrue(result.isEmpty());
    }

    @Test
    void testParseSimpleName(){
        ParamsParser parser = new ParamsParser();
        var result = parser.parse("name=lu");
        assertEquals("lu", result.get("name"));
        assertEquals(1, result.size());
    }

    @Test
    void testParseComplexNameAge(){
        ParamsParser parser = new ParamsParser();
        var result = parser.parse("name=lu;age=20");
        assertEquals("lu", result.get("name"));
        assertEquals("20", result.get("age"));
        assertEquals(2, result.size());
    }

    @Test
    void testParseComplexNameAgeAndTrim(){
        ParamsParser parser = new ParamsParser();
        var result = parser.parse("name = lu ; age = 20");
        assertEquals("lu", result.get("name"));
        assertEquals("20", result.get("age"));
        assertEquals(2, result.size());
    }

    @Test
    void testExceptionWhenInputWithoutEqual(){
        ParamsParser parser = new ParamsParser();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> parser.parse("name=lu;age")
        );

        assertEquals("Invalid key/value pair: age", exception.getMessage());
    }
    @Test
    void testExceptionWhenInputWithoutEqual2(){
        ParamsParser parser = new ParamsParser();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> parser.parse("name")
        );

        assertEquals("Invalid key/value pair: name", exception.getMessage());
    }
}
