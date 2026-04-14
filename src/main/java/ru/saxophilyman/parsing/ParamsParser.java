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

//        raw = raw.trim();
        String[] parts = raw.split(";");
        for (String part : parts) {
            String trimmedPart = part.trim();
            String[] keyValue = part.split("=");

            if (keyValue.length != 2) {
                throw new IllegalArgumentException("Invalid key/value pair: " + trimmedPart);
            }
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();
            result.put(key, value);
        }

        return result;
    }

}
