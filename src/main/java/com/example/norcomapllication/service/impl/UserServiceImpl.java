package com.example.norcomapllication.service.impl;

import com.example.norcomapllication.model.entity.RoleEntity;
import com.example.norcomapllication.model.entity.UserEntity;
import com.example.norcomapllication.model.entity.enums.RoleEnumClass;
import com.example.norcomapllication.model.service.ProfileUpdateServiceModel;
import com.example.norcomapllication.model.service.UserRegisterServiceModel;
import com.example.norcomapllication.model.view.AdminUsersViewModel;
import com.example.norcomapllication.repository.RoleRepository;
import com.example.norcomapllication.repository.UserRepository;
import com.example.norcomapllication.service.UserService;
import com.example.norcomapllication.service.errorPackage.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final NorcomUserServiceImpl norcomUserService;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository, NorcomUserServiceImpl norcomUserService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.norcomUserService = norcomUserService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initUsersAndRoles() {
        initializeRoles();
        initializeUsers();
    }

    @Override
    public boolean isFreeUsername(String username) {
        return userRepository.findByUsernameIgnoreCase(username).isEmpty();

    }

    @Override
    public UserEntity findByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User with this username: " + username+" was not found!" ));
    }

//    @Override
//    public Optional<User> findfById(Long id) {
//        Optional<User> byId = userRepository.findById(id);
//        return byId;
//    }

    @Override
    public void updateProfile(ProfileUpdateServiceModel profileUpdateServiceModel) {
        UserEntity user = userRepository.findById(profileUpdateServiceModel.getId()).orElseThrow(() -> new ObjectNotFoundException("User with id" + profileUpdateServiceModel.getId() + "not found!"));
        user.setUsername(profileUpdateServiceModel.getUsername())
                .setAddress(profileUpdateServiceModel.getAddress())
                .setEmail(profileUpdateServiceModel.getEmail())
                .setGender(profileUpdateServiceModel.getGender());
        userRepository.save(user);
    }

    @Override
    public List<AdminUsersViewModel> getAllUsersByFetch() {
        return userRepository.getAllUsersByFetch().stream().map(user -> modelMapper.map(user,AdminUsersViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public void promoteToAdmin(Long id) {
        userRepository.findById(id)
                .ifPresent(user -> {
                    Set<RoleEntity> roles = new HashSet<>();
                    roles.add(roleRepository.findByRole(RoleEnumClass.ADMIN));
                    user.setRoles(roles);
                    userRepository.save(user);
                });

    }

    @Override
    public void demoteAdmin(Long id) {
        userRepository.findById(id)
                .ifPresent(user -> {
                    Set<RoleEntity> roles = new HashSet<>();
                    roles.add(roleRepository.findByRole(RoleEnumClass.USER));
                    user.setRoles(roles);
                    userRepository.save(user);
                });
    }


    private void initializeRoles() {
        if (roleRepository.count() == 0) {
            RoleEntity admin = new RoleEntity();
            admin.setRole(RoleEnumClass.ADMIN);

            RoleEntity user = new RoleEntity();
            user.setRole(RoleEnumClass.USER);

            roleRepository.saveAll(Set.of(admin, user));
        }
    }

    private void initializeUsers() {
        if (userRepository.count() == 0) {

            RoleEntity adminRole = roleRepository.findByRole(RoleEnumClass.ADMIN);
            RoleEntity userRole = roleRepository.findByRole(RoleEnumClass.USER);

            UserEntity admin = new UserEntity();
            admin.setFullName("Admin Adminov");
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin4o"));
            admin.setAddress("st.Rezbarska 69");
            admin.setEmail("adminovk@gmail.com");
            admin.setGender("male");
            admin.setRoles(Set.of(adminRole));
            userRepository.save(admin);

            UserEntity user = new UserEntity();
            user.setFullName("Troyan Userov");
            user.setUsername("troyan");
            user.setPassword(passwordEncoder.encode("troy4o"));
            user.setAddress("st.Stamboliiski 47");
            user.setEmail("userovt@gmail.com");
            user.setGender("male");
            user.setRoles(Set.of(userRole));
            userRepository.save(user);

        }
    }

    @Override
    public void registerAndLoginUser(UserRegisterServiceModel userRegisterServiceModel) {
        RoleEntity role = roleRepository.findByRole(RoleEnumClass.USER);
        UserEntity newUser = new UserEntity();
        newUser.setFullName(userRegisterServiceModel.getFullName())
                .setAddress(userRegisterServiceModel.getAddress())
                .setEmail(userRegisterServiceModel.getEmail())
                .setGender(userRegisterServiceModel.getGender())
                .setUsername(userRegisterServiceModel.getUsername())
                .setPassword(passwordEncoder.encode(userRegisterServiceModel.getPassword()))
                .setRoles(Set.of(role));
        newUser = userRepository.save(newUser);

        UserDetails principal = norcomUserService.loadUserByUsername(newUser.getUsername());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                newUser.getPassword(),
                principal.getAuthorities()
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}
