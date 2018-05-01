package com.asadkhan.network.helpers;

public class NetworkException extends Throwable {

    private String errorMessage;

    public static NetworkException createInstance() {
        return new NetworkException();
    }

    public static NetworkException createInstance(String error) {
        NetworkException exception = new NetworkException();
        exception.errorMessage = error;
        return exception;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
