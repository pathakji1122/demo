package com.example.demo.Return;

import com.example.demo.Auth.User;
import org.springframework.data.annotation.Id;

public class ReturnedUser {
    public ReturnedUser(String email, String name, String branch) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Id

    private String email;
    private String name;

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    private String branch;





}
