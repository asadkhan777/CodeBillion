package com.asadkhan.threading;

import com.asadkhan.threading.threadhandlers.ThreadHandler;
import com.asadkhan.threading.threadhandlers.ThreadHandlerExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ThreadingModule {

    private static ThreadHandlerExecutor executor;

    public ThreadingModule() {
        initialize();
    }

    private ThreadHandlerExecutor initialize() {
        if (executor == null) {
            executor = new ThreadHandlerExecutor();
        }
        return executor;
    }

    @Provides
    @Singleton
    public ThreadHandler getThreadHandler() {
        return initialize();
    }

}
