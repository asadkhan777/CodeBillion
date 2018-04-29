package com.asadkhan.codebillion.app.features.editor.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.asadkhan.codebillion.app.R;
import com.asadkhan.codebillion.app.features.editor.interactor.CompilerPresenter;
import com.asadkhan.codebillion.app.features.editor.utilities.TemplateUtil;
import com.asadkhan.codebillion.code.editor.base.models.CompileResultDO;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity implements CompilerView {


    @BindView(R.id.et_code_text)
    EditText etCodeEditText;

    @BindView(R.id.et_inputs)
    EditText etInputText;

    @BindView(R.id.sp_language)
    Spinner spLanguage;


    @Inject
    CompilerPresenter presenter;

    ArrayAdapter<String> adapter;
    List<String> languageList;

    private String sourceCode = "";
    private int languageId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        languageList = getLanguages();
        setUpSpinner();

        etCodeEditText.setText(TemplateUtil.cpp());
    }

    private List<String> getLanguages() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("C++");
        return list;
    }

    private void setUpSpinner() {
        adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, languageList);
        spLanguage.setAdapter(adapter);
        spLanguage.setPrompt("Select a language");
        spLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.err.println(position);
                String lang = adapter.getItem(position);
                System.err.println(id);
                System.err.println(lang);
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
        String code = etCodeEditText.getText().toString();
        String input = etInputText.getText().toString();
        if (notEmpty(code)) {
            showMessage(code);
        }
        if (notEmpty(input)) {
            showMessage(input);
        }
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
    public void displayResults(CompileResultDO compileResultDO) {
        if (compileResultDO == null) return;
        showMessage(compileResultDO);
    }


}
