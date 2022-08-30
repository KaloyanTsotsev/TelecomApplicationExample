package com.example.norcomapllication.model.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    public String fullName;
    public String address;
    public String email;
    public String gender;
    public String username;
    public String password;
    public Set<OrderEntity> orders;
    private Set<RoleEntity> roles = new HashSet<>();
    private Set<DeviceEntity> devices;
    private Set<MobilePlanEntity> mobilePlans;

    public UserEntity() {
    }

    @Column(unique = true, nullable = false)
    public String getFullName() {
        return fullName;
    }

    public UserEntity setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @Column(nullable = false)

    public String getAddress() {
        return address;
    }

    public UserEntity setAddress(String address) {
        this.address = address;
        return this;

    }

    @Column(unique = true, nullable = false)
    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;

    }

    @Column(nullable = false)
    public String getGender() {
        return gender;
    }

    public UserEntity setGender(String gender) {
        this.gender = gender;
        return this;

    }

    @Column(unique = true, nullable = false)
    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;

    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;

    }

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    public Set<OrderEntity> getOrder() {
        return orders;
    }

    public UserEntity setOrder(Set<OrderEntity> orders) {
        this.orders = orders;
        return this;

    }

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public UserEntity setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
        return this;

    }

    @OneToMany
    public Set<DeviceEntity> getDevices() {
        return devices;
    }

    public UserEntity setDevices(Set<DeviceEntity> devices) {
        this.devices = devices;
        return this;

    }

    @OneToMany
    public Set<MobilePlanEntity> getMobilePlans() {
        return mobilePlans;
    }

    public void setMobilePlans(Set<MobilePlanEntity> mobilePlans) {
        this.mobilePlans = mobilePlans;
    }
}
