package com.asadkhan.persistence.sharedPreferences;

import java.util.Map;
import java.util.Set;

/**
 * Created by nazmuddinmavliwala on 12/01/17.
 */
public interface PreferenceService {

    void put(String key, int value);

    void put(String key, float value);

    void put(String key, long value);

    void put(String key, boolean value);

    void put(String key, String value);

    void put(String key, Set<String> value);

    float get(String key, float defaultValue);

    long get(String key, long defaultValue);

    String get(String key, String defaultValue);

    boolean get(String key, boolean defaultValue);

    int get(String key, int defaultValue);

    Set<String> get(String key, Set<String> defaultValue);

    Map<String, ?> getAll();

    void remove(String key);

    void clearPreferences();

    boolean isKeyPresent(String key);
}
