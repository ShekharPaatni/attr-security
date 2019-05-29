package com.ttn.attrsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chandra Shekhar Paatni on 30/5/19
 */
@RestController
public class DummyController {

    @GetMapping(value = "/dummy")
    public String dummy() {
        return "hello I am from dummy";
    }
}
