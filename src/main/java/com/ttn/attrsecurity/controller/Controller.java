package com.ttn.attrsecurity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * @author Chandra Shekhar Paatni on 29/5/19
 */

public class Controller {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());
    public final String className = this.getClass().getName();

    public String getErrors(BindingResult bindingResult) {
        StringBuilder stringBuilder = new StringBuilder();
        for (ObjectError allError : bindingResult.getAllErrors()) {
            stringBuilder.append(allError.getDefaultMessage()).append(" ");
        }
        return stringBuilder.toString();
    }
}
