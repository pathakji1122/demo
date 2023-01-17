package com.example.demo.Registration;

import java.util.AbstractMap;
import java.util.HashMap;

public class Payment {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String email;

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    String courseType;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    String amount;
    // HashMap<Integer, String>courseAmount
    //       = new HashMap<Integer, String>(2);
    //cou


}
