package com.example.norcomapllication.web;

import com.example.norcomapllication.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;

@Controller
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @Transactional
    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("users",userService.getAllUsersByFetch());
        return "admin";
    }
    @PreAuthorize("isOwner(#id)")
    @DeleteMapping("/admin/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PatchMapping("/admin/{id}/add-admin")
    public String makeAdmin(@PathVariable Long id) {
        userService.promoteToAdmin(id);

        return "redirect:/admin";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/admin/{id}/demote-admin")
    public String demoteAdmin(@PathVariable Long id) {
        userService.demoteAdmin(id);

        return "redirect:/admin";
    }
}
