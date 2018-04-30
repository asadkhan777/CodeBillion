package com.asadkhan.codebillion.code.editor.base.presenters;

import com.asadkhan.codebillion.code.editor.base.views.BaseView;

public abstract class Presenter<VIEW extends BaseView> {

    public VIEW view;

    public Presenter(VIEW view) {
        this.view = view;
    }
}
