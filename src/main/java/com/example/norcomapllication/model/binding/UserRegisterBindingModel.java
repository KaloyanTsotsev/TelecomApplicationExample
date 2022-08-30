package com.example.norcomapllication.model.binding;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {
    public String fullName;
    public String email;
    public String username;
    public String password;
    public String confirmPassword;
    public String address;
    public String gender;

    public UserRegisterBindingModel() {
    }
    @NotNull
    @Size(min = 2,max = 35)
    public String getFullName() {
        return fullName;
    }

    public UserRegisterBindingModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
    @Email
    @NotNull
   @Size(min = 9 ,max=40)
    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;

    }
    @NotBlank
    @Size(min=4,max = 35)
    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;

    }
    @NotNull
    @Size(min=5, max=15)
    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
    @NotNull
    @Size(min=5, max=15)
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
    @NotNull
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @NotNull
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
