package com.example.norcomapllication.web;

import com.example.norcomapllication.model.binding.ProfileUpdateBindingModel;
import com.example.norcomapllication.model.entity.UserEntity;
import com.example.norcomapllication.model.service.ProfileUpdateServiceModel;
import com.example.norcomapllication.model.view.ProfileUserView;
import com.example.norcomapllication.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class ProfileController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public ProfileController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/profile")
    public String getUserProfile(Model model){

        addProfileView(model);

        return "profile";
    }



    @GetMapping("/profile/{id}/edit-profile")
    public String editProfile(Model model) {
    getUserProfile(model);
    return "edit-profile";
    }

    @GetMapping("/profile/{id}/edit-profile/errors")
    public String editProfileErrors(@PathVariable Long id, Model model) {

        return "edit-mobile-plan";
    }

    @PatchMapping("/profile/{id}/edit-profile")
    public String editMobilePlan(@PathVariable Long id, @Valid ProfileUpdateBindingModel profileUpdateBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes,@RequestParam(value = "gender", required = false) String gender) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("profileUpdateBindingModel",profileUpdateBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.profileUpdateBindingModel",bindingResult);
            return "redirect:/profile/" + id +"/edit-profile/errors";
        }

        ProfileUpdateServiceModel profileUpdateServiceModel = modelMapper.map(profileUpdateBindingModel,ProfileUpdateServiceModel.class);
        profileUpdateBindingModel.setId(id);
        profileUpdateServiceModel.setGender(gender);
        userService.updateProfile(profileUpdateServiceModel);
        return "redirect:/users/profile";
    }

    private UserEntity getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userService.findByUsername(username);
    }

    private void addProfileView(Model model) {
        UserEntity userEntity = getCurrentUser();
        ProfileUserView user = new ProfileUserView();
        user.setId(userEntity.getId());
        user.setFullName(userEntity.getFullName());
        user.setAddress(userEntity.getAddress());
        user.setGender(userEntity.getGender());
        user.setUsername(userEntity.getUsername());
        user.setEmail(userEntity.getEmail());
        model.addAttribute("user", user);
    }
}
