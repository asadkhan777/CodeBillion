package com.asadkhan.codebillion.app.features.editor.view.dialogs;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ProgressBar;

import com.asadkhan.codebillion.app.R;

import butterknife.BindColor;
import butterknife.BindView;


public class LoaderDialog extends BaseDialogFragment {

    @BindColor(R.color.colorPrimary)
    int colorPrimary;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar.setIndeterminate(true);
        progressBar.getIndeterminateDrawable()
                .setColorFilter(colorPrimary, android.graphics.PorterDuff.Mode
                        .MULTIPLY);
    }

    @Override
    protected int layout() {
        return R.layout.loader;
    }
}
