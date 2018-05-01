package com.asadkhan.codebillion.app.features.editor.di;

import com.asadkhan.codebillion.app.features.editor.view.CompilerActivity;
import com.asadkhan.codebillion.code.editor.scopes.SubClassScope;

import dagger.Subcomponent;

@SubClassScope
@Subcomponent(
        modules = {
                CompilerModule.class
        }
)
public interface CompilerComponent {

    void inject(CompilerActivity activity);

}
