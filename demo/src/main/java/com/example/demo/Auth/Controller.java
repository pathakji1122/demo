package com.example.demo.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class Controller {
    @Autowired
    Service service;

    @PostMapping(path = "login")
    public String login(@RequestBody LoginRequest loginRequest){
        Boolean loggedIn = service.login(loginRequest);
        if(loggedIn)return "Logged In with email "+ loginRequest.email;
        else{
            return "Please check your email and password";
        }
    }

    @PostMapping(path = "signup")
    public String signup(@RequestBody SignupRequest signupRequest){
        Boolean signedUp = service.signup(signupRequest);
        if(signedUp)return "Created a new user with email "+ signupRequest.email;
        else{
            return "User with this email already exists";
        }
    }

}
