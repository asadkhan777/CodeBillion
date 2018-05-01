package com.asadkhan.codebillion.app.features.editor.view.dialogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asadkhan.codebillion.code.editor.base.views.BaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseDialogFragment extends AppCompatDialogFragment implements BaseView {

    protected View view;
    protected Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(layout(), container, false);
        this.unbinder = ButterKnife.bind(this, view);
        return view;
    }

    protected abstract int layout();

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoading() {
    }

    @Override
    public void onDestroyView() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroyView();
    }

    public void tryCloseDialog() {
        try {
            dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
