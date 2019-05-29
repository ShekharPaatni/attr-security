package com.ttn.attrsecurity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Random;

/**
 * @author Chandra Shekhar Paatni on 29/5/19
 */
@ControllerAdvice
public class GenericException {

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<ApiError> getCustomException(CustomException customException) {
        return handlingException(customException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ApiError> getException(Exception e) {
        return handlingException(e.getMessage(), HttpStatus.BAD_GATEWAY);
    }

    private ResponseEntity<ApiError> handlingException(String message, HttpStatus httpStatus) {
        ApiError apiError = new ApiError(new Random().nextLong(), message, httpStatus.value());
        return new ResponseEntity<ApiError>(apiError, httpStatus);
    }
}
