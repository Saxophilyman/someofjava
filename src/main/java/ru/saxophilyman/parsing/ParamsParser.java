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
        Map<String, String> result = new HashMap<>();

        String[] parts = raw.split(";");
        for (String part : parts) {
            String[] keyValue = part.split("=");
            String key = keyValue[0];
            String value = keyValue[1];
            result.put(key, value);
        }

        return result;
    }

}
