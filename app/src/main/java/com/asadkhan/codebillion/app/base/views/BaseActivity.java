package com.asadkhan.codebillion.app.base.views;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.asadkhan.codebillion.app.base.di.BaseActivityComponent;
import com.asadkhan.codebillion.app.base.di.BaseActivityModule;
import com.asadkhan.codebillion.app.base.di.DaggerBaseActivityComponent;
import com.asadkhan.codebillion.app.features.editor.view.dialogs.LoaderDialog;
import com.asadkhan.codebillion.code.editor.base.views.BaseView;
import com.asadkhan.codebillion.code.editor.global.CodeBillionApp;

import butterknife.ButterKnife;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static android.view.inputmethod.InputMethod.SHOW_FORCED;

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

    public void hideDialogLoading() {
        LoaderDialog dialog = (LoaderDialog) getSupportFragmentManager().findFragmentByTag(LoaderDialog.class.getName());
        if (dialog != null) dialog.dismiss();
    }

    public void showDialogLoading() {
        LoaderDialog loaderDialog = new LoaderDialog();
        loaderDialog.show(getSupportFragmentManager(), LoaderDialog.class.getName());

    }

    public void hide(View v) {
        if (v == null) return;
        v.setVisibility(GONE);
    }

    public void show(View v) {
        if (v == null) return;
        v.setVisibility(VISIBLE);
    }

    protected void closeKeyboard() {
        try {
            View view = getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void openKeyboard() {
        try {
            View view = getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.showSoftInput(view, SHOW_FORCED);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract int layout();

    public BaseActivityComponent component() {
        return component;
    }
}
