package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/users/register")
    public void registerStudent(@Validated @RequestBody Student newStudent) {
        List<Student> users = studentrepository.findAll();
        System.out.println("New user: " + newStudent.toString());
        for (Student user : users) {
            if (user.equals(newStudent)) {
                System.out.println("User Already exists!");
            }
        }
        studentrepository.save(newStudent);
    }
    @PostMapping("/users/login")
    public void loginUser(@Validated @RequestBody Student student) {
        List<Student> users = studentrepository.findAll();
        for (Student other : users) {
            if (other.equals(student)) {
                studentrepository.save(student);
            }

        }
    }
        @PostMapping("/users/logout")
        public void logoutUser(@Validated @RequestBody Student student){
            List<Student> users1 = studentrepository.findAll();
            for (Student other : users1) {
                if (other.equals(student)) {
                    studentrepository.save(student);
                }
            }

        }
    }






