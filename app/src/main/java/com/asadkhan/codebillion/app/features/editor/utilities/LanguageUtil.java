package com.asadkhan.codebillion.app.features.editor.utilities;

import java.util.Arrays;
import java.util.List;

public class LanguageUtil {

    public static String[] list = {
            // "Bash (4.0)",
            "Bash (4.4)",
            "Basic (fbc 1.05.0)",
            "C (gcc 7.2.0)",
            // "C (gcc 6.4.0)",
            // "C (gcc 6.3.0)",
            // "C (gcc 5.4.0)",
            // "C (gcc 4.9.4)",
            // "C (gcc 4.8.5)",
            "C++ (g++ 7.2.0)",
            // "C++ (g++ 6.4.0)",
            // "C++ (g++ 6.3.0)",
            // "C++ (g++ 5.4.0)",
            // "C++ (g++ 4.9.4)",
            // "C++ (g++ 4.8.5)",
            "C# (mono 5.4.0.167)",
            // "C# (mono 5.2.0.224)",
            "Clojure (1.8.0)",
            "Crystal (0.23.1)",
            "Elixir (1.5.1)",
            "Erlang (OTP 20.0)",
            "Go (1.9)",
            "Haskell (ghc 8.2.1)",
            // "Haskell (ghc 8.0.2)",
            // "Insect (5.0.0)",
            // "Java (OpenJDK 9 with Eclipse OpenJ9)",
            "Java (OpenJDK 8)",
            "Java (OpenJDK 7)",
            "JavaScript (nodejs 8.5.0)",
            // "JavaScript (nodejs 7.10.1)",
            "OCaml (4.05.0)",
            "Octave (4.2.0)",
            "Pascal (fpc 3.0.0)",
            "Python (3.6.0)",
            // "Python (3.5.3)",
            "Python (2.7.9)",
            // "Python (2.6.9)",
            "Ruby (2.4.0)",
            // "Ruby (2.3.3)",
            // "Ruby (2.2.6)",
            // "Ruby (2.1.9)",
            "Rust (1.20.0)",
            "Text (plain text)"
    };

    public static List<String> getAllLanguages() {
        return Arrays.asList(list);
    }

    public static int getLanguageId(String language) {
        if (language == null || language.isEmpty()) return -1;

        switch (language) {

            case "Bash (4.4)":
                return 1;

            case "Basic (fbc 1.05.0)":
                return 3;

            case "C (gcc 7.2.0)":
                return 4;

            case "C++ (g++ 7.2.0)":
                return 10;

            case "C# (mono 5.4.0.167)":
                return 16;

            case "Clojure (1.8.0)":
                return 18;

            case "Crystal (0.23.1)":
                return 19;

            case "Elixir (1.5.1)":
                return 20;

            case "Erlang (OTP 20.0)":
                return 21;

            case "Go (1.9)":
                return 22;

            case "Haskell (ghc 8.2.1)":
                return 23;

            case "Java (OpenJDK 8)":
                return 27;

            case "Java (OpenJDK 7)":
                return 28;

            case "JavaScript (nodejs 8.5.0)":
                return 29;

            case "OCaml (4.05.0)":
                return 31;

            case "Octave (4.2.0)":
                return 32;

            case "Pascal (fpc 3.0.0)":
                return 33;

            case "Python (3.6.0)":
                return 34;

            case "Python (2.7.9)":
                return 36;

            case "Ruby (2.4.0)":
                return 38;

            case "Rust (1.20.0)":
                return 42;

            case "Text (plain text)":
                return 43;

            default: return -1;
        }
    }
}
