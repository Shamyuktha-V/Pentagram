package com.example.pentagram.backend;

import java.time.LocalDate;

public class User {
    private int id;
    private String username;
    private String email;
    private String fullName;
    private String password;
    private LocalDate dob;
    private String bio;


    public User() {
        id=0;
        username="";
        email="";
        fullName="";
        password="";
        bio="";
    }

    public User(String username, String email, String fullName, String password, LocalDate dob, String bio) {
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.dob = dob;
        this.bio = bio;
    }

    // Getter and Setter methods for all fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", dob=" + dob +
                ", bio='" + bio + '\'' +
                '}';
    }
}