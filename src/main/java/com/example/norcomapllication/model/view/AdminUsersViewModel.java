package com.example.norcomapllication.model.view;

import com.example.norcomapllication.model.entity.RoleEntity;

import java.util.Set;

public class AdminUsersViewModel {
    private Long id;
    private String username;
    private String fullName;
    private Set<RoleEntity> roles;

    public Long getId() {
        return id;
    }

    public AdminUsersViewModel setId(Long id) {
        this.id = id; return this;
    }

    public String getUsername() {
        return username;
    }

    public AdminUsersViewModel setUsername(String username) {
        this.username = username;return this;
    }

    public String getFullName() {
        return fullName;
    }

    public AdminUsersViewModel setFullName(String fullName) {
        this.fullName = fullName;return this;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public AdminUsersViewModel setRoles(Set<RoleEntity> roles) {
        this.roles = roles;return this;
    }
}
