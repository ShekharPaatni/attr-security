package com.ttn.attrsecurity.bootstrap;

import com.ttn.attrsecurity.entity.Role;
import com.ttn.attrsecurity.entity.User;
import com.ttn.attrsecurity.service.RoleService;
import com.ttn.attrsecurity.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.HashSet;

/**
 * @author Chandra Shekhar Paatni on 29/5/19
 */
@Component
public class ApplicationBootstrap implements ApplicationListener<ApplicationReadyEvent> {

    private final Logger logger = LoggerFactory.getLogger(ApplicationBootstrap.class);

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Role role = new Role("USER");
        User user = new User("user1", "user1", "user1", new HashSet<Role>(){{add(role);}});
        roleService.save(role);
        userService.save(user);
        logger.info("Done Successfully");
    }
}
