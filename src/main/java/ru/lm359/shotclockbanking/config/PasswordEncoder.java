package ru.lm359.shotclockbanking.config;

import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Getter
public class PasswordEncoder {

    BCryptPasswordEncoder passwordEncoder1;

    public PasswordEncoder() {
        this.passwordEncoder1 = passwordEncoder();
    }

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
