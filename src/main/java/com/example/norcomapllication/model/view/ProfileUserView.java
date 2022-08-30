package com.example.norcomapllication.model.view;

import com.example.norcomapllication.model.entity.DeviceEntity;
import com.example.norcomapllication.model.entity.OrderEntity;
import com.example.norcomapllication.model.entity.RoleEntity;

import java.util.HashSet;
import java.util.Set;

public class ProfileUserView {
    private Long id;
    private String fullName;
    private String address;
    private String email;
    private String gender;
    private String username;
    private String password;
    private Set<OrderEntity> orders;
    private Set<RoleEntity> roles = new HashSet<>();
    private Set<DeviceEntity> devices;

    public ProfileUserView() {
    }

    public Long getId() {
        return id;
    }

    public ProfileUserView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public ProfileUserView setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public ProfileUserView setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ProfileUserView setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ProfileUserView setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public ProfileUserView setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public ProfileUserView setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ProfileUserView setPassword(String password) {
        this.password = password;
        return this;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public ProfileUserView setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
        return this;
    }

    public Set<DeviceEntity> getDevices() {
        return devices;
    }

    public ProfileUserView setDevices(Set<DeviceEntity> devices) {
        this.devices = devices;
        return this;
    }
}
