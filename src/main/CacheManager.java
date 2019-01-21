package main;

import java.util.HashMap;
import java.util.Map;

public class CacheManager {

    private final Map<String, String> cache = new HashMap<>();

    private CacheManager() {

    }

    private static class CacheManagerLoader {
        private static final CacheManager INSTANCE = new CacheManager();
    }

    static CacheManager getInstance() {
        return CacheManagerLoader.INSTANCE;
    }

    void doCache(String key, String value) {
        cache.put(key, value);
    }

    String getValue(String key) {
        return cache.get(key);
    }

    boolean isKeyExists(String key) {
        return cache.containsKey(key);
    }
}