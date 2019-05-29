package com.ttn.attrsecurity.repo;

import com.ttn.attrsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Chandra Shekhar Paatni on 29/5/19
 */
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUserName(String name);
}
