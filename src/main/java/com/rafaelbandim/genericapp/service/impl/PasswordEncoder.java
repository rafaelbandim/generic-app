package com.rafaelbandim.genericapp.service.impl;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
class PasswordEncoder {
    private final DelegatingPasswordEncoder delegatingPasswordEncoder;

    public PasswordEncoder() {
        Argon2PasswordEncoder argon2PE = new Argon2PasswordEncoder(16, 32, 1, 1 << 17, 5);
        Map<String, org.springframework.security.crypto.password.PasswordEncoder> encoders = new HashMap<>();
        encoders.put("argon2", argon2PE);
        delegatingPasswordEncoder = new DelegatingPasswordEncoder(
                "argon2", encoders);
        delegatingPasswordEncoder.setDefaultPasswordEncoderForMatches(argon2PE);
    }

    public String encode(String password) {
        return delegatingPasswordEncoder.encode(password);
    }

    public boolean matches(String password, String encodedPassword) {
        return delegatingPasswordEncoder.matches(password, encodedPassword);
    }
}
