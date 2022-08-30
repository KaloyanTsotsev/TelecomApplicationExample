package com.example.norcomapllication.web;

import com.example.norcomapllication.model.entity.RoleEntity;
import com.example.norcomapllication.model.entity.UserEntity;
import com.example.norcomapllication.model.entity.enums.RoleEnumClass;
import com.example.norcomapllication.repository.RoleRepository;
import com.example.norcomapllication.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;
import java.util.Set;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @BeforeEach
    void initialization() {
        RoleEntity userRole = roleRepository.findByRole(RoleEnumClass.USER);
        RoleEntity adminRole = roleRepository.findByRole(RoleEnumClass.ADMIN);
        roleRepository.save(userRole);
        roleRepository.save(adminRole);
        UserEntity userForTest = new UserEntity();
        userForTest.setUsername("stamat40")
                .setFullName("Stamat Stamatov")
                .setPassword(passEncoder.encode("stamat4o"))
                .setEmail("stamat@abv.bg")
                .setGender("male")
                .setAddress("ul. Stamat 7")
                .setRoles(Set.of(userRole));
        userRepository.save(userForTest);
    }

    @AfterEach
    void deleteData() {
        userRepository.deleteAll();
        roleRepository.deleteAll();
    }

    @Test
    void testShowLoginWithoutAuthenticateUserReturnsLoginPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/login")).andExpect(status().isOk()).andExpect(view().name("login"));
    }

    @Test
    void testLoginWithAuthenticatedUser() throws Exception {
        mockMvc.perform(post("/users/login")
                        .param("username", "stamat40")
                        .param("password", "stamat4o").with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void testLoginErrorPage() throws Exception {
        mockMvc.perform(post("/users/login-error")
                        .param("username", "s")
                        .param("password", "s1").with(csrf())
                )
                .andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("http://localhost/users/login"));
    }

    @Test
    void testShowRegister() throws Exception {
        mockMvc.
                perform(MockMvcRequestBuilders.get("/users/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }
//TODO i am guessing it's not getting right radiobutton value- search it!!!
//    @Test
//    void testRegisterValidUser() throws Exception {
//        if (roleRepository.count() == 0) {
//            RoleEntity roleEntity = new RoleEntity();
//            roleEntity.setRole(RoleEnumClass.USER);
//            roleRepository.save(roleEntity);
//        }
//        mockMvc.perform(post("/users/register").
//                        param("fullName", "Test Testov").
//                        param("email", "test@abv.com").
//                        param("username", "test").
//                        param("gender", "male").
//                        param("password", "test4o").
//                        param("confirmPassword", "test4o").
//                        param("address", "ul.Test 7").
//                        with(csrf()).contentType(MediaType.APPLICATION_FORM_URLENCODED))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("http://localhost/users/login"));
//
//        Optional<UserEntity> newUserOpt = userRepository.findByUsername("test");
//
//        Assertions.assertTrue(newUserOpt.isPresent());
//
//        UserEntity newUser = newUserOpt.get();
//        Assertions.assertEquals(newUser.getUsername(), "test");
//        Assertions.assertEquals(newUser.getEmail(), "test@abv.com");
//        Assertions.assertEquals(newUser.getFullName(), "Test Testov");
//        Assertions.assertEquals(newUser.getGender(), "male");
//        Assertions.assertEquals(newUser.getAddress(), "ul.Test 7");
//        Assertions.assertEquals(4, userRepository.count());
//    }
//
//    @Test
//    void testIfPasswordsAreSame() throws Exception {
//        mockMvc.perform(post("/users/register").param("username", "roro").//
//                param("password", "123456").//
//                param("confirmPassword", "1231251231").//
//                param("fullName", "Ro Ro").//
//                param("email", "roro@ko.com").//
//                param("gender", "male").//
//                param("address", "ul.roro 113").//
//                with(csrf())).andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/users/register"));
//    }
//
//    @Test
//    void testUniqueUserName() throws Exception {
//        mockMvc.perform(post("/users/register")
//                .param("username", "stamat40").//
//                        param("password", "123456").//
//                        param("confirmPassword", "123456").//
//                        param("fullName", "Stemen Stemenov").//
//                        param("email", "adss@ad.com").//
//                        param("gender", "female").//
//                        param("address", "stemen 669").//
//                        with(csrf())).andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/users/register"));
//    }
}
