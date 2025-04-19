package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.NewUser;
import com.example.demo.repository.RegisterRepository;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private RegisterRepository registerRepository;

    public boolean validateUser(String email, String password) {
        Optional<NewUser> user = registerRepository.findByEmail(email);

        // Check if user exists and password matches
        return user.isPresent() && user.get().getPassword().equals(password);
    }
    public NewUser getUserByEmail(String email) {
        return registerRepository.findByEmail(email).orElse(null);
    }
}
