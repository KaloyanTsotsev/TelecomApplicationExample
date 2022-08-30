package com.example.norcomapllication.model.service;

public class UserRegisterServiceModel {
    private String fullName;
    private String username;
    private String password;
    public String address;
    public String email;
    public String gender;

    public String getFullName() {
        return fullName;
    }

    public UserRegisterServiceModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUsername() {
        return username != null ?
                username.trim() :
                null;
    }

    public UserRegisterServiceModel setUsername(String username) {
        this.username = username;
        return this;

    }

    public String getPassword() {
        return password;
    }

    public UserRegisterServiceModel setPassword(String password) {
        this.password = password;
        return this;

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
