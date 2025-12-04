package com.himanshu;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.himanshu.entities.User;
import com.himanshu.services.Userservices;

@SpringBootTest
@ActiveProfiles("test")
//@Transactional // rollback after each test
class UserServiceTest {

    @Autowired
    private Userservices userService;

    @Test
    void testCreateUser() {
        User user = new User("Himanshu", "himanshu@example.com");
        User savedUser = userService.saveUser(user);

        Assertions.assertNotNull(savedUser.getId());
    }

    @Test
    void testGetUserById() {
        User user = new User("Amit", "amit@example.com");
        User savedUser = userService.saveUser(user);

        User fetchedUser = userService.getUserById(savedUser.getId());
        Assertions.assertEquals("Amit", fetchedUser.getName());
    }

    @Test
    void testGetAllUsers() {
        userService.saveUser(new User("A", "a@gmail.com"));
        userService.saveUser(new User("B", "b@gmail.com"));

        List<User> list = userService.getAllUsers();
        Assertions.assertEquals(2, list.size());
    }

    @Test
    void testDeleteUser() {
        User user = new User("Raj", "raj@example.com");
        User savedUser = userService.saveUser(user);

        userService.deleteUser(savedUser.getId());
        Assertions.assertNull(userService.getUserById(savedUser.getId()));
    }
}
