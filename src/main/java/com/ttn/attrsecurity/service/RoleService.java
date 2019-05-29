package com.ttn.attrsecurity.service;


import com.ttn.attrsecurity.entity.Role;

/**
 * @author Chandra Shekhar Paatni on 29/5/19
 */
public interface RoleService {
    Role save(Role role);
    Role getByName(String name);
}
