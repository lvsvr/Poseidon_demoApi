package com.poseidon.api.demo.domain;

import com.poseidon.api.demo.repositories.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTest {

    private User user0 = new User();

    @Autowired
    private UserRepository userRepo;

    @Test
    void shouldGetUser() {
        //        GIVEN
        user0.setUsername("u0");
        user0.setPassword("1Test@dm0");
        user0.setFullName("u0");
        user0.setRole("USER");
//        WHEN
        userRepo.save(user0);
        user0.setId(1);
//        THEN
        Assert.assertNotNull(user0.getId());
        Assert.assertNotNull(user0.getPassword());
        assertEquals("u0", user0.getFullName());
        assertEquals("u0", user0.getUsername());
        assertEquals("USER", user0.getRole());
        assertEquals(1, user0.getId());
        Assert.assertNotNull(user0.toString());
    }

}

