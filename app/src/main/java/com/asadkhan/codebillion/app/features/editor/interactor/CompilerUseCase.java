package com.asadkhan.codebillion.app.features.editor.interactor;

import com.asadkhan.codebillion.app.base.interactors.BaseObserver;
import com.asadkhan.codebillion.code.editor.base.models.CompileRequestDO;
import com.asadkhan.codebillion.code.editor.base.models.CompileResultDO;
import com.asadkhan.codebillion.code.editor.base.models.TokenDO;
import com.asadkhan.codebillion.code.editor.base.presenters.UseCase;
import com.asadkhan.codebillion.code.editor.data.CompilerRepository;
import com.asadkhan.codebillion.code.editor.scopes.SubClassScope;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import retrofit2.Response;

@SubClassScope
public class CompilerUseCase extends UseCase<CompilerRepository> {

    public static final int MAX_RETRIES = 10;
    private static final int IN_QUEUE = 1;
    private static final int IN_EXECUTION = 2;
    public static int CURRENT_RETRY = 0;

    private int statusId = 1;

    @Inject
    public CompilerUseCase(CompilerRepository repository) {
        super(repository);
    }

//    public void compile(String sourceCode, int languageId, Observer<CompileResultDO> observer) {
//        repository
//
//                .compile(sourceCode, languageId)
//
//                .map(Response::body)
//
//                .map(TokenDO::getToken)
//
//                .delay(5, TimeUnit.SECONDS)
//
//                .switchMap(repository::fetchResults)
//
//                .map(Response::body)
//
//                .subscribe(observer);
//    }


    public void compile(CompileRequestDO requestDO, BaseObserver<String> observer) {
        repository
                .compile(requestDO)
                .map(Response::body)
                .map(TokenDO::getToken)
                .subscribe(observer);
    }

    public void compile(CompileRequestDO requestDO, boolean async, BaseObserver<CompileResultDO> observer) {
        Observable<Response<CompileResultDO>> resultObservable;

        if (async) {
            resultObservable = repository
                    .compileAsync(requestDO);

        } else {
            resultObservable = repository
                    .compile(requestDO)
                    .map(Response::body)
                    .map(TokenDO::getToken)
                    .delay(4, TimeUnit.SECONDS)
                    .switchMap(repository::fetchResults);
        }

        resultObservable
                .map(Response::body)
                .subscribe(observer);
    }

    public void fetchSubmission(String token, BaseObserver<CompileResultDO> observer) {
        // tryTimerRetry();
        statusId = IN_QUEUE;
        CURRENT_RETRY = 1;
        repository
                .fetchResults(token)
                .map(Response::body)
                .switchMap(compileResultDO -> {
                    statusId = compileResultDO.getStatus().getId();
                    CURRENT_RETRY++;
                    if (statusId == IN_QUEUE || statusId == IN_EXECUTION) {
                        return Observable.just(token)
                                .delay(1500, TimeUnit.MILLISECONDS)
                                .switchMap(repository::fetchResults)
                                .map(Response::body);
                    }
                    return Observable.just(compileResultDO);
                })
                // if it returns true,
                //      the returned Observable completes;
                // if it returns false,
                //      the upstream Observable is resubscribed.;
                .repeatUntil(() -> (CURRENT_RETRY > MAX_RETRIES || (statusId != IN_EXECUTION && statusId != IN_QUEUE)))
                .subscribe(observer);
    }

    private void tryTimerRetry() {
        Disposable subscribe = Observable.timer(1, TimeUnit.SECONDS)
                .doOnSubscribe(s -> System.out.println("subscribing"))
                .map(v -> {
                    throw new RuntimeException();
                })
                .retryWhen(errors -> {
                    AtomicInteger counter = new AtomicInteger();
                    return errors
                            .takeWhile(e -> counter.getAndIncrement() != 3)
                            .flatMap(e -> {
                                System.out.println("delay retry by " + counter.get() + " second(s)");
                                return Observable.timer(counter.get(), TimeUnit.SECONDS);
                            });
                })
                .map(Object::toString)
                .subscribe(System.err::println);
    }

//    // Retry on failure logic
//                .retryWhen(errors -> {
//                    AtomicInteger counter = new AtomicInteger();
//                    return errors
//                            .takeWhile(e -> counter.getAndIncrement() != MAX_RETRIES)
//                            .flatMap(e -> {
//                                System.out.println("Delay retry by " + counter.get() + " second(s)");
//                                return Observable
//                                        .timer(counter.get(), TimeUnit.SECONDS)
//                                        .flatMap(aLong -> repository.fetchResults(token));
//                            });
//                })
}
