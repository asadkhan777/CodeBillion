package com.asadkhan.codebillion.app.features.editor.interactor;

import com.asadkhan.codebillion.code.editor.base.models.CompileResultDO;
import com.asadkhan.codebillion.code.editor.base.models.TokenDO;
import com.asadkhan.codebillion.code.editor.base.presenters.UseCase;
import com.asadkhan.codebillion.code.editor.data.CompilerRepository;

import javax.inject.Inject;

import io.reactivex.Observer;
import retrofit2.Response;

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

                .switchMap(repository::fetchResults)

                .map(Response::body)

                .subscribe(observer);
    }


}
