package com.ttn.attrsecurity.config;

import com.ttn.attrsecurity.entity.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;
import java.util.Optional;

/**
 * @author Chandra Shekhar Paatni on 29/5/19
 */
public class CustomAuditAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        if (Objects.nonNull(SecurityContextHolder.getContext().getAuthentication())) {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return Optional.of(
                    ((User) principal).getUserName()
            );
        }else {
            return Optional.of("sam");
        }
    }
}
