package com.asadkhan.threading.threadhandlers;

import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;

/**
 * Kreated by Asad Khan on 09|Apr|2018 at 13:36.
 */

public interface ThreadHandler {

    Scheduler getBackgroundScheduler();

    Scheduler getMainThreadScheduler();

    <O> ObservableTransformer<O, O> schedule();
}
