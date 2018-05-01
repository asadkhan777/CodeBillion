package com.asadkhan.codebillion.code.editor.global;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class GlobalModule {

    private final Application application;

    public GlobalModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return this.application;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return this.application;
    }


}
