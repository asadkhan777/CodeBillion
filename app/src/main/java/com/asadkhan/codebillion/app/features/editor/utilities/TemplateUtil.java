package com.asadkhan.codebillion.app.features.editor.utilities;

public class TemplateUtil {

    public static String bash() {
        return "#!/bin/bash\n" +
                "# your code goes here";
    }


    public static String basic() {
        return "PRINT hello world;";
    }

    public static String c() {
        return "#include <stdio.h>\n" +
                "\n" +
                "int main(void) {\n" +
                "\t// your code goes here\n" +
                "\treturn 0;\n" +
                "}\n";
    }

    public static String cppExample() {
        return "#include <stdio.h>" +
                "\nint main(void) {" +
                "\n\t\tchar name[10];" +
                "\n\t\tscanf(\"%s\", name);" +
                "\n\t\tprintf(\"hello, %s\", name);" +
                "\n\t\treturn 0;\n}";
    }

    public static String cpp() {
        return "#include <stdio.h>" +
                "\nint main(void) {" +
                "\n\t\t// your code comes here" +
                "\n\t\treturn 0;\n}";
    }

    public static String cPlusPlus() {
        return "#include <iostream>\n" +
                "using namespace std;\n" +
                "\n" +
                "int main() {\n" +
                "\t// your code goes here\n" +
                "\treturn 0;\n" +
                "}";
    }

    public static String cSharp() {
        return "using System;\n" +
                "\n" +
                "public class Test\n" +
                "{\n" +
                "\tpublic static void Main()\n" +
                "\t{\n" +
                "\t\t// your code goes here\n" +
                "\t}\n" +
                "}";
    }

    public static String clojure() {
        return "user=> (println \"Hello, world!\")";
    }

    public static String crystal() {
        return "puts \"Hello world!\"";
    }

    public static String elixir() {
        return "IO.puts \"Hello world from Elixir\"";
    }

    public static String erlang() {
        return "-module(prog).\n" +
                "-export([main/0]).\n" +
                "\n" +
                "main() ->\n" +
                "\t% your code goes here\n" +
                "\ttrue.";
    }

    public static String go() {
        return "package main\n" +
                "import \"fmt\"\n" +
                "\n" +
                "func main(){\n" +
                "\t// your code goes here\n" +
                "}";
    }

    public static String haskell() {
        return "main = -- your code goes here";
    }

    public static String java() {
        return "/* package whatever; // don't place package name! */\n" +
                "\n" +
                "import java.util.*;\n" +
                "import java.lang.*;\n" +
                "\n" +
                "/* Name of the class has to be \"Main\" only if the class is public. */\n" +
                "class SomeClass\n" +
                "{\n" +
                "\tpublic static void main (String[] args) throws java.lang.Exception\n" +
                "\t{\n" +
                "\t\t// your code goes here\n" +
                "\t}\n" +
                "}";
    }

    public static String javaScript() {
        return "// your code goes here\n\t";
    }

    public static String oCaml() {
        return "(* your code goes here *)\n\t";
    }

    public static String octave() {
        return "# your code goes here\n\t";
    }

    public static String pascal() {
        return "program xBillion;\n" +
                "begin\n" +
                "\t(* your code goes here *)\n" +
                "end.";
    }

    public static String python() {
        return "# your code goes here\n";
    }

    public static String ruby() {
        return "# your code goes here\n";
    }

    public static String rust() {
        return "use std::io::stdin;\n" +
                "use std::io::BufRead;\n" +
                "use std::io::BufReader;\n" +
                "\n" +
                "fn main() {\n" +
                "\n\t" +
                "}";
    }

    public static String textPlain() {
        return "Place your text here";
    }

    public static String getTemplate(String language) {
        if (language == null || language.isEmpty()) return "";
        switch (language) {

            case "Bash (4.4)": 
                return bash();

            case "Basic (fbc 1.05.0)":
                return basic();

            case "C (gcc 7.2.0)": 
                return c();

            case "C++ (g++ 7.2.0)": 
                return cPlusPlus();

            case "C# (mono 5.4.0.167)": 
                return cSharp();

            case "Clojure (1.8.0)": 
                return clojure();

            case "Crystal (0.23.1)": 
                return crystal();

            case "Elixir (1.5.1)": 
                return elixir();

            case "Erlang (OTP 20.0)": 
                return erlang();

            case "Go (1.9)": 
                return go();

            case "Haskell (ghc 8.2.1)": 
                return haskell();

            case "Java (OpenJDK 8)": 
                return java();

            case "Java (OpenJDK 7)": 
                return java();

            case "JavaScript (nodejs 8.5.0)": 
                return javaScript();

            case "OCaml (4.05.0)": 
                return oCaml();

            case "Octave (4.2.0)": 
                return octave();

            case "Pascal (fpc 3.0.0)": 
                return pascal();

            case "Python (3.6.0)": 
                return python();

            case "Python (2.7.9)": 
                return python();

            case "Ruby (2.4.0)": 
                return ruby();

            case "Rust (1.20.0)": 
                return rust();

            case "Text (plain text)": 
                return textPlain();
                    
            default: return "";
        }
    }
}
