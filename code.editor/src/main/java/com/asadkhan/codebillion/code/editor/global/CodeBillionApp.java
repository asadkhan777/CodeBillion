package com.asadkhan.codebillion.code.editor.global;

import android.app.Application;

import com.asadkhan.network.di.NetworkModule;
import com.asadkhan.persistence.di.PersistenceModule;
import com.asadkhan.threading.ThreadingModule;

public class CodeBillionApp extends Application {

    private static GlobalComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerGlobalComponent.builder()
                .globalModule(new GlobalModule(this))
                .persistenceModule(new PersistenceModule(this))
                .networkModule(new NetworkModule())
                .threadingModule(new ThreadingModule())
//                .servicesModule(new ServicesModule(this))
//                .dataModule(new DataModule())
                .build();
    }

    public static GlobalComponent component() {
        return component;
    }
}
