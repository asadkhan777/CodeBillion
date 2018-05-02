package com.asadkhan.codebillion.code.editor.global;

import android.app.Application;

import com.asadkhan.codebillion.code.editor.data.di.DataModule;
import com.asadkhan.network.di.NetworkModule;
import com.asadkhan.persistence.di.PersistenceModule;
import com.asadkhan.threading.ThreadingModule;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class CodeBillionApp extends Application {

    private static GlobalComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        stabWithDagger();
        initializeFirebaseConfig();
    }

    public void stabWithDagger() {
        component = DaggerGlobalComponent.builder()
                .globalModule(new GlobalModule(this))
                .persistenceModule(new PersistenceModule(this))
                .networkModule(new NetworkModule())
                .threadingModule(new ThreadingModule())
                .dataModule(new DataModule())
                //.servicesModule(new ServicesModule(this))
                .build();
    }

    private void initializeFirebaseConfig() {
        FirebaseRemoteConfig remoteConfig = FirebaseRemoteConfig.getInstance();
        remoteConfig.setConfigSettings(new FirebaseRemoteConfigSettings.Builder().setDeveloperModeEnabled(true).build());
        remoteConfig
                .fetch(100)
                .addOnSuccessListener(task -> {
                    remoteConfig.activateFetched();
                    System.err.println("Task succeeded");
                    component.getRetrofitService().reset();
                })
                .addOnCompleteListener(task -> {
                    System.err.println("Task completed");
                })
                .addOnFailureListener(e -> {
                    e.printStackTrace();
                    System.err.println("Task failed");
                });
    }

    public static GlobalComponent component() {
        return component;
    }
}
