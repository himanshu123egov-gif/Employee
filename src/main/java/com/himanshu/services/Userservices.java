package com.himanshu.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.himanshu.entities.User;
import com.himanshu.repositories.Userrepositories;

@Service
public class Userservices {

    private final Userrepositories userRepository;

    public Userservices(Userrepositories userRepository) {
        this.userRepository = userRepository;
    }

    // Create or Update User
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Fetch single user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Fetch all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Delete user by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
