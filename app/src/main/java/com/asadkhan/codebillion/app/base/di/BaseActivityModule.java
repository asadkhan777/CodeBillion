package com.asadkhan.codebillion.app.base.di;

import com.asadkhan.codebillion.app.base.views.BaseActivity;
import com.asadkhan.codebillion.code.editor.base.views.BaseView;
import com.asadkhan.codebillion.code.editor.scopes.ParentClassScope;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseActivityModule {

    private final BaseActivity activity;

    public BaseActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ParentClassScope
    public BaseActivity provideActivity() {
        return this.activity;
    }

    @Provides
    @ParentClassScope
    public BaseView provideBaseView() {
        return this.activity;
    }


}
