package com.asadkhan.codebillion.code.editor.base.presenters;

import com.asadkhan.network.interactors.NetworkService;
import com.asadkhan.threading.threadhandlers.ThreadHandler;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import okhttp3.ResponseBody;
import retrofit2.Response;

public abstract class DataRepository implements Repository {

    protected NetworkService networkService;
    protected ThreadHandler threadHandler;

    public DataRepository(NetworkService networkServiceInstance, ThreadHandler threadHandlerInstance) {
        this.networkService = networkServiceInstance;
        this.threadHandler = threadHandlerInstance;

    }

    Observable<Response<ResponseBody>> getSubmission(String token) {
        String path = String.format("/submissions/%s", token);
        return networkService.get(ResponseBody.class, path).compose(schedule());
    }

    public <O> ObservableTransformer<O, O> schedule() {
        return threadHandler.schedule();
    }
}
