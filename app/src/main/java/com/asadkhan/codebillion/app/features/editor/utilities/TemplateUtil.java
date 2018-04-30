package com.asadkhan.codebillion.app.features.editor.utilities;

public class TemplateUtil {

    public static String cpp() {
        return "#include <stdio.h>\nint main(void) {\n\tchar name[10];\n\tscanf(\"%s\", name);\n\tprintf(\"hello, %s\", name);\n\treturn 0;\n}";
    }
}
