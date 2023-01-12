package com.example.demo.Auth;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    UserRepository userRepository;

    public Boolean login(LoginRequest loginRequest) {
        String email = loginRequest.email;
        String password = loginRequest.password;

        User user = findUserByEmail(email);
        if (user == null) {
            return false;
        }

        if (user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    private User findUserByEmail(String email) {
        User user = userRepository.findOneByEmail(email);
        return user;
    }

    public Boolean signup(SignupRequest signupRequest) {
        String email = signupRequest.email;
        User user = findUserByEmail(email);
        if (user != null) {
            return false;
        }

        User newUser = new User(signupRequest.name, signupRequest.email, signupRequest.password);
        saveUser(newUser);
        return true;
    }

    private void saveUser(User newUser) {
        userRepository.save(newUser);
    }
}
