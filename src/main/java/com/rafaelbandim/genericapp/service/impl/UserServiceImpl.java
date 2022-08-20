package com.rafaelbandim.genericapp.service.impl;

import com.rafaelbandim.genericapp.configuration.AuthenticationImpl;
import com.rafaelbandim.genericapp.entity.User;
import com.rafaelbandim.genericapp.repository.UserRepository;
import com.rafaelbandim.genericapp.service.UserService;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void signIn(User user) {
        User existentUser = userRepository.findByUsername(user.getUsername()).stream().findFirst().orElse(null);
        if (existentUser == null || !passwordEncoder.matches(user.getPassword(), existentUser.getPassword())) {
            throw new AuthenticationCredentialsNotFoundException("Bad credentials");
        }
        AuthenticationImpl authentication = new AuthenticationImpl(existentUser);
        authentication.setAuthenticated(true);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
