package com.asadkhan.codebillion.app.features.editor.view;

import com.asadkhan.codebillion.code.editor.base.models.CompileResultDO;
import com.asadkhan.codebillion.code.editor.base.views.BaseNetworkView;

public interface CompilerView extends BaseNetworkView {

    void saveToken(String token);

    void displayResults(CompileResultDO compileResultDO);


}
