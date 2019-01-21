package main;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharactersCalculator {

    public static CacheManager cacheManager = CacheManager.getInstance();

    public static String doCalculations(String input) {
        String result;
        if (cacheManager.isKeyExists(input)) {
            result = cacheManager.getValue(input);
        } else {
            result = countUniqueCharacters(input);
            cacheManager.doCache(input, result);
        }

        return result;
    }

    public static String countUniqueCharacters(String input) {
        Map<Character, Integer> result = new LinkedHashMap<>();

        for (char character : input.toCharArray()) {
            int value = 1;
            if (result.containsKey(character)) {
                value += result.get(character);
            }
            result.put(character, value);
        }
        return prepareOutPut(result);
    }

    private static String prepareOutPut(Map<Character, Integer> rawData) {
        StringBuilder output = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : rawData.entrySet()) {
            output.append("\"").append(entry.getKey()).append("\" - ").append(entry.getValue()).append("\n");
        }

        return output.toString();
    }

}
