package com.fushi.util;

public class Response<T> {

    private Integer statusCode;
    private String message;
    private  T data;

    public Response() { }

    public Response(Integer code, String message) {
        this.statusCode = code;
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public Response<T> setStatusCode(Integer code) {
        this.statusCode = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Response<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Response<T> setData(T data) {
        this.data = data;
        return this;

    }
}
