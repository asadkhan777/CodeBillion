package com.asadkhan.codebillion.code.editor.utils;

import android.text.Editable;

public class StringUtils {


    public static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean isEmpty(Editable editable) {
        return editable == null || editable.toString().isEmpty();
    }

    public static boolean notEmpty(String string) {
        return string != null && !string.isEmpty();
    }

    public static boolean notEmpty(Editable editable) {
        return editable != null && !editable.toString().isEmpty();
    }

}
