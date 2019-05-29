package com.ttn.attrsecurity.controller;

import com.ttn.attrsecurity.entity.User;
import com.ttn.attrsecurity.exception.CustomException;
import com.ttn.attrsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Chandra Shekhar Paatni on 29/5/19
 */
@RestController
public class UserController extends Controller {
    @Autowired
    UserService userService;

    @PostMapping(value = "/registration")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user, final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new CustomException(getErrors(bindingResult), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }
}
