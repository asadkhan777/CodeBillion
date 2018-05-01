package com.asadkhan.codebillion.app.base.interactors;

import com.asadkhan.codebillion.code.editor.base.views.BaseNetworkView;

import io.reactivex.disposables.Disposable;

import static com.asadkhan.codebillion.code.editor.utils.NetworkUtil.getErrorCode;

public abstract class BaseNetworkObserver<DATA> extends BaseObserver<DATA> {

    private BaseNetworkView view;

    public BaseNetworkObserver() {
    }

    protected BaseNetworkObserver(BaseNetworkView view) {
        this.view = view;
    }

    public BaseNetworkObserver<DATA> setView(BaseNetworkView view) {
        this.view = view;
        return this;
    }

    @Override
    public void onSubscribe(Disposable d) {
        view.showLoading();
        super.onSubscribe(d);
    }

    @Override
    public void onComplete() {
        view.hideLoading();
        super.onComplete();
    }

    @Override
    public void onError(Throwable throwable) {
        try {
            view.hideLoading();
            super.onError(throwable);
            int errorCode = getErrorCode(throwable);
            view.handleNetworkError(errorCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
