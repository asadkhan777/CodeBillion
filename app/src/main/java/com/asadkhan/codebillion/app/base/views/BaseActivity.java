package com.asadkhan.codebillion.app.base.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.asadkhan.codebillion.app.base.di.BaseActivityComponent;
import com.asadkhan.codebillion.app.base.di.BaseActivityModule;
import com.asadkhan.codebillion.app.base.di.DaggerBaseActivityComponent;
import com.asadkhan.codebillion.code.editor.base.views.BaseView;
import com.asadkhan.codebillion.code.editor.global.CodeBillionApp;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    BaseActivityComponent component;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout());
        ButterKnife.bind(this);
        component = DaggerBaseActivityComponent.builder()
                .baseActivityModule(new BaseActivityModule(this))
                .globalComponent(CodeBillionApp.component())
                .build();
        component.inject(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    public abstract int layout();

    public BaseActivityComponent component() {
        return component;
    }
}
