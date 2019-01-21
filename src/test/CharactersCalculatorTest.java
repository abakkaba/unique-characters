package test;

import main.CacheManager;
import main.CharactersCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class CharactersCalculatorTest {

    CacheManager expectedCache = CharactersCalculator.cacheManager;

    @Test
    void testDoCalculations_CacheShouldBeSame() {
        String input = "Hello world!";
        CharactersCalculator.doCalculations(input);
        assertSame(expectedCache, CharactersCalculator.cacheManager, "cache test");
    }

    @Test
    void testDoCalculations_countUniqueCharactersShouldNotReorderInput() {
        String input = "Hi, hello world!";
        String result = CharactersCalculator.countUniqueCharacters(input);
        String expected = "\"H\" - 1\n" +
                "\"i\" - 1\n" +
                "\",\" - 1\n" +
                "\" \" - 2\n" +
                "\"h\" - 1\n" +
                "\"e\" - 1\n" +
                "\"l\" - 3\n" +
                "\"o\" - 2\n" +
                "\"w\" - 1\n" +
                "\"r\" - 1\n" +
                "\"d\" - 1\n" +
                "\"!\" - 1\n";
        assertEquals(expected, result, "countUniqueCharacters test");
        assertSame(expectedCache, CharactersCalculator.cacheManager, "cache test");
    }

    @Test
    void testDoCalculations_CalculationsOutputColumnShouldBeInSameOrder() {
        String input = "Hello world!";
        String result = CharactersCalculator.doCalculations(input);
        String expected = "\"H\" - 1\n" +
                "\"e\" - 1\n" +
                "\"l\" - 3\n" +
                "\"o\" - 2\n" +
                "\" \" - 1\n" +
                "\"w\" - 1\n" +
                "\"r\" - 1\n" +
                "\"d\" - 1\n" +
                "\"!\" - 1\n";
        assertEquals(expected, result, "output test");
        assertSame(expectedCache, CharactersCalculator.cacheManager, "cache test");
    }
}