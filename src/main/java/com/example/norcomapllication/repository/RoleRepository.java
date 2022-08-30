package com.example.norcomapllication.repository;

import com.example.norcomapllication.model.entity.RoleEntity;
import com.example.norcomapllication.model.entity.enums.RoleEnumClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {

    RoleEntity findByRole(RoleEnumClass administrator);
}
