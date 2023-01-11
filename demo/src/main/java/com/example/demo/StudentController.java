package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
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

}


