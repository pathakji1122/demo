package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("student")

@RestController
public class StudentController {
@Autowired
    private Studentrepository studentrepository;
    @PostMapping("/addStudent")
    public String saveBook(@RequestBody Student student){
        studentrepository.save(student);

        return "Added Successfully";
    }

    @GetMapping("/findallstudents")
    public List<Student> getBooks() {
        return studentrepository.findAll();
    }


    @DeleteMapping("/delete/{id}")
    public String deletestudent(@PathVariable int id){
        studentrepository.deleteById(id);

        return "Deleted Successfully";
    }
    @Autowired
    Service service;
    @PostMapping(path = "login")
    public String login(@RequestBody Loginrequest loginRequest){
        Boolean loggedIn = service.login(loginRequest);
        if(loggedIn)return "Logged In with email "+ loginRequest.enrollno;
        else{
            return "Please check your email and password";
        }
    }
    @PostMapping(path = "signup")
    public String signup(@RequestBody Signuprequest signupRequest){
        Boolean signedUp = service.signup(signupRequest);
        if(signedUp)return "Created a new user with email "+ signupRequest.enrollno;
        else{
            return "User with this email already exists";
        }
    }




}






