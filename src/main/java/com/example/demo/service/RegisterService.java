package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.NewUser;
import com.example.demo.repository.RegisterRepository;

@Service
public class RegisterService {

    @Autowired
    private RegisterRepository registerRepository;

    public boolean isUserExists(String email) {
        return registerRepository.findByEmail(email).isPresent(); // Check if user exists
    }

    public void registerUser(NewUser user) {
        registerRepository.save(user); // Save new user if they don’t exist
    }
}
