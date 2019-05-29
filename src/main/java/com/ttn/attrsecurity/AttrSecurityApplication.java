package com.ttn.attrsecurity;

import com.ttn.attrsecurity.config.CustomAuditAware;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.sql.DataSource;

@SpringBootApplication
@EnableWebSecurity
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AttrSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(AttrSecurityApplication.class, args);
    }


    @Bean
    public AuditorAware<String> auditorAware() {
         return new CustomAuditAware();
    }
}
