package com.asadkhan.codebillion.code.editor.utils;

import java.io.IOException;

import retrofit2.HttpException;

public class NetworkUtil {

    public static int getErrorCode(Throwable e) {
        if (e == null) return -1;
        if (e instanceof HttpException) {
            return ((HttpException) e).code();
        }
        if (e instanceof IOException) {
            return 0;
        }
        return -1;
    }

    public static String getErrorString(int code) {
        if (code == 0) return "Network Connection Error. Please check if you are connected to the interwebz";

        if (code < 100 || code > 600) {
            return "Something went wrong.";
        }
        int codeCategory = code % 100;
        switch (codeCategory) {
            case 1:
            case 2:
                return "";
            case 3:
                return "Redirecting you ...";

            case 4: {
                switch (code) {
                    case 400:
                        return "Validation error! Please check the inputs";

                    case 401:
                        return "Unauthorized! You're not allowed to access this.";

                    case 403:
                        return "Forbidden. Zombies will be on their way if you don't leave at once!";

                    case 404:
                        return "This is not the resource you're looking for. Please check again";

                    case 429:
                        return "Woah there, hold your horses! Please try again after some time.";

                    default:
                        return "Something went wrong. Please verify before trying again";
                }
            }

            case 5: {
                switch (code) {
                    case 500:
                        return "Server error! Our Ninja Coder cats are fixing the issue as we speak.";

                    case 501:
                        return "Server error! Looks like this action is not ready yet.";

                    case 502:
                        return "Server error! Has someone broken the interwebs? How can this be?";

                    case 503:
                        return "Server error! This service is temporarily down. Let's hum a song till it's up again!";

                    case 504:
                        return "Server error! The chain of connection broke somewhere. We're looking into it!";

                    default:
                        return "Something went wrong. Please verify before trying again";
                }

            }


        }

        return "Something went wrong.";
    }
}
