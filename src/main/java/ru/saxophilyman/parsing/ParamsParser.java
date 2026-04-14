package ru.saxophilyman.parsing;

import java.util.HashMap;
import java.util.Map;

public class ParamsParser {

    public Map<String, String> parse(String raw){
        //null
        if (raw == null) {
            throw new IllegalArgumentException("Input must not be null");
        }
        //empty
        if (raw.isEmpty()) {
            return Map.of();
        }

        Map<String, String> result = new HashMap<>();

        String[] pairs = raw.split(";");
        for (String pair : pairs) {
            String trimmedPair = pair.trim();
            String[] keyValue = pair.split("=");

            if (keyValue.length != 2) {
                throw new IllegalArgumentException("Invalid key/value pair: " + trimmedPair);
            }
            //trimRaw
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();
            //emptyKey
            if (key.isEmpty()) {
                throw new IllegalArgumentException("Key must not be empty");
            }
            //duplicateKey
            if (result.containsKey(key)){
                throw new IllegalArgumentException("Duplicate key: " + key);
            }

            result.put(key, value);
        }

        return result;
    }

}
