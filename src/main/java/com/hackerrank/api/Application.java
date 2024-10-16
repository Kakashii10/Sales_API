package com.hackerrank.api;

import com.hackerrank.api.model.User;
import com.hackerrank.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        User u = new User();
        u.setId(1L);
        u.setUsername("mohit");
        u.setPassword(passwordEncoder.encode("123"));
        u.setRoles(new ArrayList<>(Arrays.asList("ROLE_USER", "ROLE_ADMIN")));

        userRepository.save(u);
    }
}
