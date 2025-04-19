package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.NewUser;
import com.example.demo.repository.UserRepository;

@Service // Marks this class as a Service layer
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Adds a new user to the database.
     */
    public NewUser addUser(String name, String email) {
        NewUser user = new NewUser();
        user.setName(name);
        user.setEmail(email);
        return userRepository.save(user);
    }

    /**
     * Fetches all users from the database.
     */
    public List<NewUser> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Saves a user object to the database.
     */
    public NewUser saveUser(NewUser user) {
        return userRepository.save(user);
    }
    
    /**
     * Fetch user by email.
     */
    public NewUser getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
