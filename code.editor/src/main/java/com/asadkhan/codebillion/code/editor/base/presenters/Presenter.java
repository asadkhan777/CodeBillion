package com.asadkhan.codebillion.code.editor.base.presenters;

import com.asadkhan.codebillion.code.editor.base.views.BaseNetworkView;

public abstract class Presenter<VIEW extends BaseNetworkView> {

    public VIEW view;

    public Presenter(VIEW view) {
        this.view = view;
    }

}
