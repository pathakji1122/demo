package com.example.demo;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
public class Student {
    @Id
    private int enrollno;
    private String name;
    private String branch;
    private String password;

    public Student(int enrollno, String name, String branch,String password) {

        this.enrollno = enrollno;
        this.name = name;
        this.branch = branch;
        this.password=password;
    }

    public Student(int enrollno, String name,String password) {

    }

    public void setEnrollno(int enrollno) {
        this.enrollno = enrollno;
    }
    public int getEnrollno() {
        return enrollno;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
    public String getBranch() {
        return branch;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

}
