package com.ttn.attrsecurity.service;

import com.ttn.attrsecurity.entity.Role;
import com.ttn.attrsecurity.entity.User;
import com.ttn.attrsecurity.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Chandra Shekhar Paatni on 29/5/19
 */
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (Objects.isNull(user))
            throw new UsernameNotFoundException("Username is invalid: " + username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>() {{
            for (Role role: user.getRoles()) {
                add(new SimpleGrantedAuthority(role.getName()));
            }
        }};

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities);
    }
}
