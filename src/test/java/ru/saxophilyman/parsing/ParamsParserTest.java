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
    void testParseSimple(){
        ParamsParser parser = new ParamsParser();
        var result = parser.parse("name=lu");
        assertEquals("lu", result.get("name"));
        assertEquals(1, result.size());
    }
}
