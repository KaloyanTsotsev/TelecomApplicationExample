package com.example.norcomapllication.service.impl;

import com.example.norcomapllication.model.entity.RoleEntity;
import com.example.norcomapllication.model.entity.UserEntity;
import com.example.norcomapllication.model.entity.enums.RoleEnumClass;
import com.example.norcomapllication.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@ExtendWith({MockitoExtension.class})
class NorcomUserServiceImplTest {
    private UserEntity userForTest;
    private RoleEntity adminRoleTest,userRoleTest;
    private NorcomUserServiceImpl norcomUserServiceTest;
    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    void initialization() {
        norcomUserServiceTest = new NorcomUserServiceImpl(mockUserRepository);
        adminRoleTest = new RoleEntity();
        adminRoleTest.setRole(RoleEnumClass.ADMIN);
        userRoleTest = new RoleEntity();
        userRoleTest.setRole(RoleEnumClass.USER);

        userForTest = new UserEntity();
        userForTest.setUsername("stamat40")
                .setPassword("stamat4o")
                .setEmail("stamat@abv.bg")
                .setGender("male")
                .setAddress("ul. Stamat 7")
                .setRoles(Set.of(adminRoleTest,userRoleTest));
    }

    @Test
    void testUserThrowsErrorIfNotFound() {
        Assert.assertThrows(UsernameNotFoundException.class,()-> norcomUserServiceTest.loadUserByUsername("invalid_stamat"));
    }
    @Test
    void testSuccessUserFound() {
        Mockito.when(mockUserRepository.findByUsername(userForTest.getUsername())).thenReturn(Optional.of(userForTest));
        UserDetails userDetails = norcomUserServiceTest.loadUserByUsername(userForTest.getUsername());
        String expectedRoles= "ROLE_ADMIN, ROLE_USER";
        String roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(", "));
        Assertions.assertEquals(userDetails.getUsername(),userForTest.getUsername());
        Assertions.assertEquals(expectedRoles,roles);
    }
}
