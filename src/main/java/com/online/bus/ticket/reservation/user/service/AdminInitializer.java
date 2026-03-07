package com.online.bus.ticket.reservation.user.service;

import com.online.bus.ticket.reservation.user.model.AuthorizedUser;
import com.online.bus.ticket.reservation.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminInitializer {

    @Bean
    CommandLineRunner createAdminUser(UserRepository repository,
                                      PasswordEncoder passwordEncoder) {

        return args -> {

            if(repository.findByUsername("admin").isEmpty()) {

                AuthorizedUser admin = new AuthorizedUser();

                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("password"));
                admin.setUserFirstName("System");
                admin.setUserLastName("Administrator");
                admin.setRole("ROLE_ADMIN");
                admin.setStatus("ACTIVE");

                repository.save(admin);

                System.out.println("Default ADMIN user created");
            }
        };
    }
}