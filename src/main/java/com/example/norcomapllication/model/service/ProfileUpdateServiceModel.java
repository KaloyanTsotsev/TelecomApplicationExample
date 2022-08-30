package com.example.norcomapllication.model.service;

public class ProfileUpdateServiceModel {
    private Long id;
    private String email;
    private String address;
    private String username;
    private String gender;
    private String fullName;

    public Long getId() {
        return id;
    }

    public ProfileUpdateServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ProfileUpdateServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ProfileUpdateServiceModel setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public ProfileUpdateServiceModel setUsername(String username) {
        this.username = username; return this;
    }

    public String getGender() {
        return gender;
    }

    public ProfileUpdateServiceModel setGender(String gender) {
        this.gender = gender; return this;
    }

    public String getFullName() {
        return fullName;
    }

    public ProfileUpdateServiceModel setFullName(String fullName) {
        this.fullName = fullName; return this;
    }
}
