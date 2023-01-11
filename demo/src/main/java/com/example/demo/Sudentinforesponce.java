package com.example.demo;

public class Sudentinforesponce {
    private int enrollno;
    private String name;
    private String branch;

    public Sudentinforesponce(int enrollno, String name, String branch) {
        this.enrollno= enrollno;
        this.name = name;
        this.branch = branch;

    }

    public int getEnrollno() {
        return enrollno;
    }

    public void setEnrollno(int enrollno) {
        this.enrollno = enrollno;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
