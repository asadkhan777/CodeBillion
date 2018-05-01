package com.asadkhan.codebillion.app.base.di;

import com.asadkhan.codebillion.app.base.views.BaseActivity;
import com.asadkhan.codebillion.app.features.editor.di.CompilerComponent;
import com.asadkhan.codebillion.app.features.editor.di.CompilerModule;
import com.asadkhan.codebillion.code.editor.global.GlobalComponent;
import com.asadkhan.codebillion.code.editor.scopes.ParentClassScope;
import com.asadkhan.network.interactors.NetworkService;
import com.asadkhan.persistence.sharedPreferences.PreferenceService;

import dagger.Component;

@ParentClassScope
@Component(
        modules = {
                BaseActivityModule.class
        },
        dependencies = {
                GlobalComponent.class
        }
)
public interface BaseActivityComponent {

    void inject(BaseActivity activity);

    BaseActivity getActivity();

    PreferenceService getSharedPrefService();

    NetworkService getNetworkService();

    CompilerComponent getCompilerComponent(CompilerModule module);

}
