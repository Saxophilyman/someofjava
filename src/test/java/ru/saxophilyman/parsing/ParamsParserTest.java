package ru.saxophilyman.parsing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParamsParserTest {

    @Test
    void testErrorNull(){
        ParamsParser parser = new ParamsParser();
        assertThrows(IllegalArgumentException.class, () -> parser.parse(null));
    }
}
