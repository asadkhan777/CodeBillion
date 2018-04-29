package com.asadkhan.codebillion.code.editor.global;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;

import com.asadkhan.network.di.NetworkModule;
import com.asadkhan.network.interactors.NetworkService;
import com.asadkhan.persistence.auth.AuthenticationService;
import com.asadkhan.persistence.di.PersistenceModule;
import com.asadkhan.persistence.sharedPreferences.PreferenceService;
import com.asadkhan.threading.ThreadingModule;
import com.asadkhan.threading.threadhandlers.ThreadHandler;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                GlobalModule.class,
                NetworkModule.class,        // network
                ThreadingModule.class,      // thread management
                PersistenceModule.class,    // persistence
                // DataModule.class,        // data = persistence + n/w
                // ServicesModule.class     // services
        }
)
public interface GlobalComponent {

        Application getApplication();

        Context getApplicationContext();


        /** Network dependencies
         */

        Gson getGson();

        NetworkService getNetworkService();



        /** Persistence dependencies
         */

        PreferenceService getPreferences();

        AuthenticationService getAuthenticationService();

        ContentResolver getContentResolver();

        /** Thread management dependencies
         */

        ThreadHandler getThreadHandler();

}
