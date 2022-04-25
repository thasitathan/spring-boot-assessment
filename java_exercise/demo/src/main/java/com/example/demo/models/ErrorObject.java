package com.example.demo.models;

public class ErrorObject {

    private String message;

    public ErrorObject(String msg) {
        this.message = msg;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }


}
