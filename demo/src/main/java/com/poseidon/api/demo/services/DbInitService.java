package com.poseidon.api.demo.services;

import com.poseidon.api.demo.domain.User;
import com.poseidon.api.demo.repositories.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DbInitService implements CommandLineRunner {
    private static final Logger logger = LogManager.getLogger(com.poseidon.api.demo.DemoApplication.class);
    private UserRepository userRepository;

    public DbInitService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = new User("admin", encoder.encode("1Test@dm0"), "admin", "ADMIN");
        User u0 = new User("u0", encoder.encode("1Test@dm0"), "u0", "USER");
        this.userRepository.save(user);
        this.userRepository.save(u0);
    }

}
