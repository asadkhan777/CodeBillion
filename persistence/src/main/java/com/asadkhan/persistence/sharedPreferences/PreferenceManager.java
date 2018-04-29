package com.asadkhan.persistence.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.asadkhan.persistence.SharedPrefConstants;

import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class PreferenceManager implements PreferenceService {

    private final SharedPreferences preferences;

    @Inject
    public PreferenceManager(Context context) {
        preferences = context
                .getApplicationContext()
                .getSharedPreferences(
                    SharedPrefConstants.SHARED_PREF_NAME ,
                        Context.MODE_PRIVATE);
    }

    @Override
    public void put(String key, int value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    @Override
    public void put(String key, float value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    @Override
    public void put(String key, long value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    @Override
    public void put(String key, boolean value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    @Override
    public void put(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    @Override
    public void put(String key, Set<String> value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putStringSet(key, value);
        editor.apply();
    }

    @Override
    public float get(String key, float defaultValue) {
        return preferences.getFloat(key, defaultValue);
    }

    @Override
    public long get(String key, long defaultValue) {
        return preferences.getLong(key, defaultValue);
    }

    @Override
    public String get(String key, String defaultValue) {
        return preferences.getString(key, defaultValue);
    }

    @Override
    public boolean get(String key, boolean defaultValue) {
        return preferences.getBoolean(key, defaultValue);
    }

    @Override
    public int get(String key, int defaultValue) {
        return preferences.getInt(key, defaultValue);
    }

    @Override
    public Set<String> get(String key, Set<String> defaultValue) {
        return preferences.getStringSet(key, defaultValue);
    }

    @Override
    public Map<String, ?> getAll() {
        return preferences.getAll();
    }

    @Override
    public void remove(String key) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key).apply();
    }

    @Override
    public void clearPreferences() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear().apply();
    }

    @Override
    public boolean isKeyPresent(String key) {
        return preferences.contains(key);
    }
}
