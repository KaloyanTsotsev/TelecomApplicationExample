package com.example.norcomapllication.model.entity;

import com.example.norcomapllication.model.entity.enums.RoleEnumClass;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity {
    private Long id;
    private RoleEnumClass role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public RoleEntity setId(Long id) {
        this.id = id;
        return this;
    }
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public RoleEnumClass getRole() {
        return role;
    }

    public RoleEntity setRole(RoleEnumClass role) {
        this.role = role;
        return this;
    }
}
