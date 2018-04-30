package com.asadkhan.codebillion.app.features.editor.interactor;

import com.asadkhan.codebillion.app.base.interactors.BaseObserver;
import com.asadkhan.codebillion.app.features.editor.view.CompilerView;
import com.asadkhan.codebillion.code.editor.base.models.CompileRequestDO;
import com.asadkhan.codebillion.code.editor.base.models.CompileResultDO;
import com.asadkhan.codebillion.code.editor.base.presenters.Presenter;
import com.asadkhan.codebillion.code.editor.scopes.SubClassScope;

import javax.inject.Inject;

@SubClassScope
public class CompilerPresenter extends Presenter<CompilerView> {

    private CompilerUseCase useCase;

    @Inject
    public CompilerPresenter(CompilerView view, CompilerUseCase useCaseInstace) {
        super(view);
        this.useCase = useCaseInstace;
    }

    public void compile(String sourceCode, int languageId) {
        useCase.compile(sourceCode, languageId, new BaseObserver<CompileResultDO>() {

            @Override
            public void onNext(CompileResultDO compileResultDO) {
                view.displayResults(compileResultDO);
            }
        });
    }

    public void compile(CompileRequestDO requestDO) {
        useCase.compile(requestDO, new BaseObserver<CompileResultDO>() {

            @Override
            public void onNext(CompileResultDO compileResultDO) {
                view.displayResults(compileResultDO);
            }
        });
    }

}
