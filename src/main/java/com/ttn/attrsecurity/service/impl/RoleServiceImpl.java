package com.ttn.attrsecurity.service.impl;

import com.ttn.attrsecurity.entity.Role;
import com.ttn.attrsecurity.repo.RoleRepository;
import com.ttn.attrsecurity.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Chandra Shekhar Paatni on 29/5/19
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByName(String name) {
        return roleRepository.findByName(name);
    }
}
