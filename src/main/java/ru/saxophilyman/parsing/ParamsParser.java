package ru.saxophilyman.parsing;

import java.util.HashMap;
import java.util.Map;

public class ParamsParser {

    public Map<String, String> parse(String raw){
        if (raw == null) {
            throw new IllegalArgumentException("Input must not be null");
        }
        if (raw.isEmpty()) {
            return Map.of();
        }
        return new HashMap<String, String>();
    }

}
