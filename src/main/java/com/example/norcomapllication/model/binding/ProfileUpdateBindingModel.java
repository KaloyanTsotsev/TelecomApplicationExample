package com.example.norcomapllication.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class ProfileUpdateBindingModel {
    private Long id;
    private String address;
    private String username;
    private String email;
    private String gender;

    public Long getId() {
        return id;
    }

    public ProfileUpdateBindingModel setId(Long id) {
        this.id = id;
        return this;
    }
    @NotNull
    public String getAddress() {
        return address;
    }

    public ProfileUpdateBindingModel setAddress(String address) {
        this.address = address;
        return this;
    }
    @NotNull
    public String getUsername() {
        return username;
    }

    public ProfileUpdateBindingModel setUsername(String username) {
        this.username = username; return this;
    }

    @Email
    @NotNull
    public String getEmail() {
        return email;
    }

    public ProfileUpdateBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getGender() {
        return gender;
    }
    @NotNull
    public ProfileUpdateBindingModel setGender(String gender) {
        this.gender = gender; return this;
    }
}
