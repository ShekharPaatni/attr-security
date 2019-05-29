package com.ttn.attrsecurity.repo;

import com.ttn.attrsecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Chandra Shekhar Paatni on 29/5/19
 */
public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByName(String roleName);
}
