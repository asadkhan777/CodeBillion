package com.asadkhan.persistence.di;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;

import com.asadkhan.persistence.auth.AuthenticationService;
import com.asadkhan.persistence.auth.AuthenticationManager;
import com.asadkhan.persistence.sharedPreferences.PreferenceManager;
import com.asadkhan.persistence.sharedPreferences.PreferenceService;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class PersistenceModule {

    private final Context context;

    public PersistenceModule(Application application) {
        this.context = application;
    }

    @Singleton
    @Provides
    public ContentResolver provideResolver() {
        return context.getApplicationContext().getContentResolver();
    }

    @Provides
    @Singleton
    public PreferenceService providePreferenceService() {
        return new PreferenceManager(context.getApplicationContext());
    }

    @Provides
    @Singleton
    public File provideCacheDir() {
        return context.getApplicationContext().getCacheDir();
    }

    @Provides
    @Singleton
    public AuthenticationService provideAuthentication(AuthenticationManager authManager) {
        return authManager;
    }


}
