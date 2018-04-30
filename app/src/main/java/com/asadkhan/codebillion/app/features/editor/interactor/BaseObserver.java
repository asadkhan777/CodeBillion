package com.asadkhan.codebillion.app.features.editor.interactor;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<DATA> implements Observer<DATA> {

    @Override
    public void onSubscribe(Disposable d) {
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.err.println("Completed");
    }
}
