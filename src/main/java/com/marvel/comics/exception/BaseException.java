package com.marvel.comics.exception;

public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1;

    private final ErrorData errorData;

    public BaseException(ErrorData errorData) {
        super(errorData.getMessage());
        this.errorData = errorData;
    }

    public BaseException(ErrorData errorData, Throwable cause) {
        super(errorData.getMessage(), cause);
        this.errorData = errorData;
    }

    public ErrorData getErrorData() {
        return this.errorData;
    }
}
