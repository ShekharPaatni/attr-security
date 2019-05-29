package com.ttn.attrsecurity.service.impl;

import com.ttn.attrsecurity.entity.User;
import com.ttn.attrsecurity.repo.UserRepository;
import com.ttn.attrsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Chandra Shekhar Paatni on 29/5/19
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByUserName(String name) {
        return userRepository.findByUserName(name);
    }
}
