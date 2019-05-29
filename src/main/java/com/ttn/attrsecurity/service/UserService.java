package com.ttn.attrsecurity.service;

import com.ttn.attrsecurity.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author Chandra Shekhar Paatni on 29/5/19
 */
@Service
public interface UserService {
    User save(User user);
    User findByUserName(String name);
}
