package com.example.norcomapllication.service.impl;

import com.example.norcomapllication.model.entity.UserEntity;
import com.example.norcomapllication.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NorcomUserServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public NorcomUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity user =  userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User with that "+username+" does not exists!"));
    return mapUserDetails(user);
    }

    private UserDetails mapUserDetails(UserEntity user) {
        List<GrantedAuthority> authorities =
                user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole().name())).collect(Collectors.toList());

        return new NorcomUser(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }
}
