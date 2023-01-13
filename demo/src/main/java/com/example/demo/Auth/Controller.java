package com.example.demo.Auth;

import com.example.demo.Return.ReturnedService;
import com.example.demo.Return.ReturnedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class Controller {
    @Autowired
    Service service;
    @Autowired
    ReturnedService returnedService;


    @PostMapping(path = "login")

    public ReturnedUser login(@RequestBody LoginRequest loginRequest){
        Boolean loggedIn = service.login(loginRequest);
        String useremail= loginRequest.email;
        ReturnedUser returnedUser1= returnedService.getData(useremail);
        if(loggedIn)return returnedUser1;
        else{
            return null;
        }
    }

    @PostMapping(path = "signup")
    public String signup(@RequestBody SignupRequest signuprequest){
        Boolean signedUp = service.signup(signuprequest);
        if(signedUp)return "Created a new user with email "+ signuprequest.email;
        else{
            return "User with this email already exists";
        }
    }

}

