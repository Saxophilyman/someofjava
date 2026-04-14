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
        String[] parts = raw.split("=");
        String key = parts[0];
        String value = parts[1];
        return Map.of(key, value);
    }

}
