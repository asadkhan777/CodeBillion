package com.asadkhan.codebillion.app.features.editor.view;

import com.asadkhan.codebillion.code.editor.base.models.CompileResultDO;
import com.asadkhan.codebillion.code.editor.base.views.BaseView;

public interface CompilerView extends BaseView {

    void displayResults(CompileResultDO compileResultDO);

}
