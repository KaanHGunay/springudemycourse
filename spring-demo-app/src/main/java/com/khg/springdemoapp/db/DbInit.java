package com.khg.springdemoapp.db;

import com.khg.springdemoapp.model.entity.User;
import com.khg.springdemoapp.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DbInit implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("a", passwordEncoder.encode("a"), "ADMIN", "TEST2");
        User user2 = new User("b", passwordEncoder.encode("b"), "USER", "TEST2");
        userRepository.saveAll(Arrays.asList(user, user2));
    }
}
