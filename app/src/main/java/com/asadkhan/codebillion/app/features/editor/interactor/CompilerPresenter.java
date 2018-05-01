package com.asadkhan.codebillion.app.features.editor.interactor;

import com.asadkhan.codebillion.app.base.interactors.BaseNetworkObserver;
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

    public void compile(CompileRequestDO requestDO) {
        useCase.compile(requestDO, new BaseNetworkObserver<String>(view) {

            @Override
            public void onNext(String token) {
                view.saveToken(token);
            }
        });
    }

    public void fetchSubmission(String token) {
        view.showLoading();
        useCase.fetchSubmission(token, new BaseNetworkObserver<CompileResultDO>(view) {

            @Override
            public void onNext(CompileResultDO results) {
                view.hideLoading();
                view.displayResults(results);
            }
        });
    }

//
//    public void compileAndReturnResult(CompileRequestDO requestDO) {
//        view.showLoading();
//        useCase.compile(requestDO, false, new BaseObserver<CompileResultDO>() {
//
//            @Override
//            public void onComplete() {
//                super.onComplete();
//                view.hideLoading();
//            }
//
//            @Override
//            public void onNext(CompileResultDO compileResultDO) {
//                view.displayResults(compileResultDO);
//            }
//        });
//    }
}
