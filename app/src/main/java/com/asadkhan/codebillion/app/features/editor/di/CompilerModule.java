package com.asadkhan.codebillion.app.features.editor.di;

import com.asadkhan.codebillion.app.features.editor.view.CompilerActivity;
import com.asadkhan.codebillion.app.features.editor.view.CompilerView;
import com.asadkhan.codebillion.code.editor.scopes.SubClassScope;

import dagger.Module;
import dagger.Provides;

@Module
public class CompilerModule {

    private CompilerActivity activity;

    public CompilerModule(CompilerActivity activity) {
        this.activity = activity;
    }

    @SubClassScope
    @Provides
    public CompilerView provideCompilerView() {
        return this.activity;
    }

    @SubClassScope
    @Provides
    public CompilerActivity provideCompilerActivity() {
        return this.activity;
    }

}
