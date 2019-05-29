package com.ttn.attrsecurity.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Chandra Shekhar Paatni on 29/5/19
 */
public class ApiError {
    private Long id;
    private String message;
    private int statusCode;

    public ApiError(Long id, String message, int statusCode) {
        this.id = id;
        this.message = message;
        this.statusCode = statusCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
