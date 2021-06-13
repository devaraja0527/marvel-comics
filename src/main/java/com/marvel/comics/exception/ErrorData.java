package com.marvel.comics.exception;

import java.io.Serializable;

public final class ErrorData implements Serializable {
    private Integer statusCode;

    private String code;

    private String message;

    public ErrorData() {
    }

    public ErrorData(String message) {
        this(null, null, message);
    }

    public ErrorData(String message, String code) {
        this(null, code, message);
    }

    public ErrorData(Integer statusCode, String code, String message) {
        this.code = code;
        this.statusCode = statusCode;
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorData{" +
                "statusCode=" + statusCode +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
