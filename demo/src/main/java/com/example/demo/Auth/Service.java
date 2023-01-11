package com.example.demo.Auth;

import java.util.ArrayList;

@org.springframework.stereotype.Service
public class Service {
    ArrayList<User> DB = new ArrayList<>();
    public Boolean login(LoginRequest loginRequest) {
        String email = loginRequest.email;
        String password = loginRequest.password;

        User user  = findUserByEmail(email);
        if(user == null){
            return false;
        }

        if(user.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    private User findUserByEmail(String email) {
        for(User user : DB){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    public Boolean signup(SignupRequest signupRequest) {
        String email = signupRequest.email;
        User user = findUserByEmail(email);
        if(user != null){
            return false;
        }

        User newUser = new User(signupRequest.name, signupRequest.email, signupRequest.password);
        saveUser(newUser);
        return true;
    }

    private void saveUser(User newUser) {
        DB.add(newUser);
    }
}
