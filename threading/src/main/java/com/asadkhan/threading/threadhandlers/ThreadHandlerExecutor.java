package com.asadkhan.threading.threadhandlers;

import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Kreated by Asad Khan on 09|Apr|2018 at 13:38.
 */

public class ThreadHandlerExecutor implements ThreadHandler {

    // private Scheduler backgroundThreadScheduler;

    private Scheduler mainThreadScheduler;

    public Scheduler getBackgroundScheduler() {
        return Schedulers.newThread();
    }

    public Scheduler getMainThreadScheduler() {
        if (mainThreadScheduler == null) {
            mainThreadScheduler = AndroidSchedulers.mainThread();
        }
        return mainThreadScheduler;
    }

    public <O> ObservableTransformer<O, O> schedule() {
        return observable -> observable
                .subscribeOn(getBackgroundScheduler())
                .observeOn(getMainThreadScheduler());
    }
}
