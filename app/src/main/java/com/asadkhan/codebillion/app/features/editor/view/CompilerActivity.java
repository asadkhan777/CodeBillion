package com.asadkhan.codebillion.app.features.editor.view;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.asadkhan.codebillion.app.R;
import com.asadkhan.codebillion.app.base.views.BaseActivity;
import com.asadkhan.codebillion.app.features.editor.di.CompilerModule;
import com.asadkhan.codebillion.app.features.editor.interactor.CompilerPresenter;
import com.asadkhan.codebillion.code.editor.base.models.CompileRequestDO;
import com.asadkhan.codebillion.code.editor.base.models.CompileResultDO;
import com.asadkhan.codebillion.code.editor.base.models.Status;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnTextChanged;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import static android.view.View.*;
import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.makeText;
import static com.asadkhan.codebillion.app.features.editor.utilities.LanguageUtil.getAllLanguages;
import static com.asadkhan.codebillion.app.features.editor.utilities.LanguageUtil.getLanguageId;
import static com.asadkhan.codebillion.app.features.editor.utilities.TemplateUtil.getTemplate;
import static com.asadkhan.codebillion.code.editor.utils.NetworkUtil.getErrorString;
import static com.asadkhan.codebillion.code.editor.utils.StringUtils.isEmpty;
import static com.asadkhan.codebillion.code.editor.utils.StringUtils.notEmpty;

public class CompilerActivity extends BaseActivity implements CompilerView {

    public static final String EXECUTION_FAILED = "Execution Failed";
    public static final String EXECUTION_SUCCEEDED = "Execution Succeeded!";

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

    @BindView(R.id.tv_result_title)
    TextView tvResultTitle;

    @BindView(R.id.ll_loading)
    LinearLayout loadingWidget;

    @BindView(R.id.ll_result)
    LinearLayout resultWidget;

    @BindView(R.id.avi_loading)
    AVLoadingIndicatorView loadingIndicatorView;

    @Inject
    CompilerPresenter presenter;

    ArrayAdapter<String> adapter;
    List<String> languageList;
    List<String> tokenList;
    int[] colors = {
            R.color.red,
            R.color.bright_green,
            R.color.blue_dress,
            R.color.purple_amethyst,
            R.color.brown_bear,
            R.color.black,
    };

    private int languageId = -1;
    private int currentColor;
    private int colorIndex = 0;

    Observable<String> colorMap;
    Disposable colorMapDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        component()
                .getCompilerComponent(new CompilerModule(this))
                .inject(this);
        currentColor = colors[colorIndex];

        setUpSpinner();
        setUpLoader();

        tokenList = new ArrayList<>();
    }

    private void setUpSpinner() {
        languageList = getAllLanguages();
        adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, languageList);
        spLanguage.setAdapter(adapter);
        spLanguage.setPrompt("Select a language");
        spLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String lang = adapter.getItem(position);

                languageId = getLanguageId(lang); // Since first element is placeholder
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
        spLanguage.setSelection(0);

    }

    private void setUpLoader() {
        colorMap = Observable.interval(5, 3000, TimeUnit.MILLISECONDS)
                .map(aLong -> loadingWidget)
                .map(LinearLayout::getVisibility)
                .filter(integer -> integer == VISIBLE)
                .map(integer -> cycleLoadingColor())
                .map(aBoolean -> "Setting color " + currentColor);
    }

    @OnTextChanged( { R.id.et_code_text, R.id.et_inputs } )
    public void textEdited(CharSequence c, int i, int j, int k) {
        hide(resultWidget);
    }

    @OnClick(R.id.bt_clear)
    public void clear() {
        etCodeEditText.setText("");
        etInputText.setText("");
        hide(loadingWidget);
        hide(resultWidget);
    }

    @OnEditorAction(R.id.et_code_text)
    boolean onEditorAction(TextView textView, int actionId, KeyEvent key) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            showMessage("Pressed: " + key);
            submit();
        }
        return true;
    }

    @OnClick(R.id.bt_submit)
    public void submit() {
        String sourceCode = etCodeEditText.getText().toString();
        String input = etInputText.getText().toString();

        hideResultWidget();

        CompileRequestDO requestDO;
        if (languageId == -1) {
            showMessage("Please select a valid language");
            return;
        }
        if (isEmpty(sourceCode)) {
            showMessage("Please provide some input!");
            return;
        } else {
            requestDO = new CompileRequestDO(sourceCode, languageId);
        }
        if (notEmpty(input)) {
            requestDO.setStdin(input);
        }
        closeKeyboard();
        presenter.compile(requestDO);
    }

    public void showMessage(String message) {
        if (message == null) return;
        makeText(this, message, LENGTH_LONG).show();
        System.err.println(message);

    }

    @Override
    public void showLoading() {
        System.err.println("Submitting . . . ");
        show(loadingWidget);
        colorMapDisposable = colorMap
                .subscribe(System.err::println, Throwable::printStackTrace);
    }

    private boolean cycleLoadingColor() {
        currentColor = colors[colorIndex];
        loadingIndicatorView.setIndicatorColor(getResources().getColor(currentColor));
        colorIndex++;
        if (colorIndex == colors.length) {
            colorIndex = 0;
        }
        return true;
    }

    @Override
    public void hideLoading() {
        System.err.println("HIDE LOADING");
        hide(loadingWidget);
        try {
            colorMapDisposable.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int layout() {
        return R.layout.activity_compiler;
    }

    @Override
    public void saveToken(String token) {
        if (tokenList == null) {
            tokenList = new ArrayList<>();
        }
        tokenList.add(token);
        if (notEmpty(token)) {
            presenter.fetchSubmission(token);
        }
    }

    @Override
    public void displayResults(CompileResultDO compileResultDO) {
        if (compileResultDO == null) return;
        handleResult(compileResultDO);
    }

    private void handleResult(CompileResultDO resultDO) {
        resetResultsWidget();

        if (resultDO == null) return;

        int statusCode = getResultCode(resultDO.getStatus());
        String success = "";
        String error = getErrorMessage(statusCode);

        show(tvResultTitle);
        if (notEmpty(error)) {
            showFailure();
            String text = tvFailure.getText().toString();

            text += "\n\n" + error;
            if (notEmpty(resultDO.getStderr()))
                text += "\n\n" + resultDO.getStderr();

            if (notEmpty(resultDO.getCompileOutput()))
                text += "\n\n" + resultDO.getCompileOutput();

            tvFailure.setText(text);

        } else {
            String text = tvSuccess.getText().toString();
            if (notEmpty(resultDO.getStdout())) {
                success += "\n\n" + resultDO.getStdout();
            }
            if (notEmpty(resultDO.getCompileOutput())) {
                success += "\n\n\n" + resultDO.getCompileOutput();
            }
            if (notEmpty(success)) {
                String joint = text + success;
                tvSuccess.setText(joint);
            }
        }
    }

    private String getErrorMessage(int statusCode) {
        String error = "";
        switch (statusCode) {

            case 1:
            case 2:
                showLoading();
                hideResultWidget();
                break;

            case 3:
                showSuccess();
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
        return error;
    }

    private void hideResultWidget() {
        hide(resultWidget);
        hide(tvResultTitle);
        hide(tvFailure);
        hide(tvSuccess);
    }

    private void showSuccess() {
        show(resultWidget);
        show(tvSuccess);
        hide(tvFailure);
    }

    private void showFailure() {
        show(resultWidget);
        show(tvFailure);
        hide(tvSuccess);
    }

    private void resetResultsWidget() {
        tvFailure.setText(EXECUTION_FAILED);
        tvSuccess.setText(EXECUTION_SUCCEEDED);
    }

    private int getResultCode(Status status) {
        if (status != null) return status.getId();
        return -1;
    }


    @Override
    public void handleNetworkError(int code) {
        String error = EXECUTION_FAILED + "\n\n" + getErrorString(code);
        showFailure();
        tvFailure.setText(error);
    }
}
