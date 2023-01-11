package com.example.demo;

import java.util.ArrayList;
@org.springframework.stereotype.Service

public class Service {
    ArrayList<Student> DB = new ArrayList<>();
    public Boolean login(Loginrequest loginRequest) {
        int enrollno = loginRequest.enrollno;
        String password = loginRequest.password;

        Student student  = findStudentByEnrollno(enrollno);
        if(student == null){
            return false;
        }

        if(student.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    private Student findStudentByEnrollno(int enrollno) {
        for(Student student : DB){
            if(student.getEnrollno()==(enrollno)){
                return student;
            }
        }
        return null;
    }

    public Boolean signup(Signuprequest signupRequest) {
        int enrollno = signupRequest.enrollno;
        Student student = findStudentByEnrollno(enrollno);
        if(student != null){
            return false;
        }

        Student newStudent = new Student(signupRequest.name, signupRequest.enrollno, signupRequest.password);
        saveStudent(newStudent);
        return true;
    }


    private void saveStudent(Student newStudent) {
        DB.add(newStudent);
    }
}
