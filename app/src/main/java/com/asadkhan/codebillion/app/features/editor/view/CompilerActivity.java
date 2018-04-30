package com.asadkhan.codebillion.app.features.editor.view;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.asadkhan.codebillion.app.R;
import com.asadkhan.codebillion.app.base.views.BaseActivity;
import com.asadkhan.codebillion.app.features.editor.di.CompilerModule;
import com.asadkhan.codebillion.app.features.editor.interactor.CompilerPresenter;
import com.asadkhan.codebillion.code.editor.base.models.CompileRequestDO;
import com.asadkhan.codebillion.code.editor.base.models.CompileResultDO;
import com.asadkhan.codebillion.code.editor.base.models.Status;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.makeText;
import static com.asadkhan.codebillion.app.features.editor.utilities.LanguageUtil.getAllLanguages;
import static com.asadkhan.codebillion.app.features.editor.utilities.LanguageUtil.getLanguageId;
import static com.asadkhan.codebillion.app.features.editor.utilities.TemplateUtil.cpp;
import static com.asadkhan.codebillion.app.features.editor.utilities.TemplateUtil.getTemplate;

public class CompilerActivity extends BaseActivity implements CompilerView {

    public static final String EXECUTION_FAILED = "Execution Failed";
    
    @BindView(R.id.et_code_text)
    EditText etCodeEditText;

    @BindView(R.id.et_inputs)
    EditText etInputText;

    @BindView(R.id.sp_language)
    Spinner spLanguage;

    @BindView(R.id.tv_result_success)
    TextView tvSuccess;

    @BindView(R.id.tv_result_failure)
    TextView tvFailure;

    @Inject
    CompilerPresenter presenter;

    ArrayAdapter<String> adapter;
    List<String> languageList;

    private String sourceCode = "";
    private String input = "";
    private int languageId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        component()
                .getCompilerComponent(new CompilerModule(this))
                .inject(this);
        languageList = getAllLanguages();
        setUpSpinner();
        spLanguage.setSelection(2);
        etCodeEditText.setText(cpp());
    }

    private void setUpSpinner() {
        adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, languageList);
        spLanguage.setAdapter(adapter);
        spLanguage.setPrompt("Select a language");
        spLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String lang = adapter.getItem(position);

                languageId = getLanguageId(lang);
                String template = getTemplate(lang);

                etCodeEditText.setText(template);
                etCodeEditText.setSelection(etCodeEditText.getText().length());
                System.err.println("Selected language : " + lang);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                System.err.println(parent);
            }
        });

    }

    @OnClick(R.id.bt_clear)
    public void clear() {
        etCodeEditText.setText("");
        etInputText.setText("");
    }

    @OnClick(R.id.bt_submit)
    public void submit() {
        sourceCode = etCodeEditText.getText().toString();
        input = etInputText.getText().toString();
        CompileRequestDO requestDO;
        if (isEmpty(sourceCode)) {
            showMessage("Please provide some input!");
            return;
        } else {
            requestDO = new CompileRequestDO(sourceCode, languageId);
        }
        if (notEmpty(input)) {
            requestDO.setStdin(input);
        }
        tvFailure.setVisibility(GONE);
        tvSuccess.setVisibility(GONE);
        presenter.compile(requestDO);
    }

    private boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

    private boolean isEmpty(Editable editable) {
        return editable == null || editable.toString().isEmpty();
    }

    private boolean notEmpty(String string) {
        return string != null && !string.isEmpty();
    }

    private boolean notEmpty(Editable editable) {
        return editable != null && !editable.toString().isEmpty();
    }

    public void showMessage(String message) {
        if (message == null) return;
        makeText(this, message, LENGTH_LONG).show();
        System.err.println(message);

    }

    public void showMessage(Object message) {
        if (message == null) return;
        makeText(this, message.toString(), LENGTH_LONG).show();
        System.err.println(message);
    }

    @Override
    public void showLoading() {
        showMessage("Loading . . . ");
    }

    @Override
    public void hideLoading() {
    }

    @Override
    public int layout() {
        return R.layout.activity_compiler;
    }

    @Override
    public void displayResults(CompileResultDO compileResultDO) {
        if (compileResultDO == null) return;
        showMessage(compileResultDO);
        handleResult(compileResultDO);
    }

    private void handleResult(CompileResultDO resultDO) {
        if (resultDO == null) return;
        tvFailure.setText(EXECUTION_FAILED);
        int resultCode = getResultCode(resultDO.getStatus());
        String error = "";

        switch (resultCode) {

            case 3:
                tvSuccess.setVisibility(VISIBLE);
                tvFailure.setVisibility(GONE);
                break;

            case 4:
                error = "Wrong Answer";
                break;
            case 5:
                error = "Time Limit Exceeded";
                break;
            case 6:
                error = "Compilation Error";
                break;
            case 7:
                error = "Runtime Error (SIGSEGV)";
                break;
            case 8:
                error = "Runtime Error (SIGXFSZ)";
                break;
            case 9:
                error = "Runtime Error (SIGFPE)";
                break;
            case 10:
                error = "Runtime Error (SIGABRT)";
                break;
            case 11:
                error = "Runtime Error (NZEC)";
                break;
            case 12:
                error = "Runtime Error (Other)";
                break;
            case 13:
                error = "Internal Error";
                break;

            default:
                error = "Something went wrong";
        }
        if (notEmpty(error)) {
            tvFailure.setVisibility(VISIBLE);
            tvSuccess.setVisibility(GONE);
            String text = tvFailure.getText().toString();

            text += "\n\n" + error;
            if (notEmpty(resultDO.getStderr()))
                text += "\n\n" + resultDO.getStderr();

            if (notEmpty(resultDO.getCompileOutput()))
                text += "\n\n" + resultDO.getCompileOutput();

            tvFailure.setText(text);
        }
    }

    private int getResultCode(Status status) {
        if (status != null) return status.getId();
        return -1;
    }


}
