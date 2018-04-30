package com.asadkhan.codebillion.app.features.editor.interactor;

import com.asadkhan.codebillion.app.base.interactors.BaseObserver;
import com.asadkhan.codebillion.code.editor.base.models.CompileRequestDO;
import com.asadkhan.codebillion.code.editor.base.models.CompileResultDO;
import com.asadkhan.codebillion.code.editor.base.models.TokenDO;
import com.asadkhan.codebillion.code.editor.base.presenters.UseCase;
import com.asadkhan.codebillion.code.editor.data.CompilerRepository;
import com.asadkhan.codebillion.code.editor.scopes.SubClassScope;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observer;
import retrofit2.Response;

@SubClassScope
public class CompilerUseCase extends UseCase<CompilerRepository> {

    @Inject
    public CompilerUseCase(CompilerRepository repository) {
        super(repository);
    }

    public void compile(String sourceCode, int languageId, Observer<CompileResultDO> observer) {
        repository

                .compile(sourceCode, languageId)

                .map(Response::body)

                .map(TokenDO::getToken)

                .delay(5, TimeUnit.SECONDS)

                .switchMap(repository::fetchResults)

                .map(Response::body)

                .subscribe(observer);
    }


    public void compile(CompileRequestDO requestDO, BaseObserver<CompileResultDO> observer) {
        repository

                .compile(requestDO)

                .map(Response::body)

                .map(TokenDO::getToken)

                .delay(5, TimeUnit.SECONDS)

                .switchMap(repository::fetchResults)

                .map(Response::body)

                .subscribe(observer);

    }
}
