package com.marvel.comics.exception;

public class EventFailedException extends BaseException{

    private static final long serialVersionUID = 1L;

    public EventFailedException(String message) {
        super(new ErrorData(message));
    }

    public EventFailedException(String message, int statusCode) {
        super(new ErrorData(statusCode, null, message));
    }
}