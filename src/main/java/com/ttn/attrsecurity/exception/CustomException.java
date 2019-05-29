package com.ttn.attrsecurity.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Chandra Shekhar Paatni on 29/5/19
 */
public class CustomException  extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private HttpStatus statusCode;

    public CustomException(String message, HttpStatus httpStatus) {
        super(message);
        this.statusCode = httpStatus;
    }
}
