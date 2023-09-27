package ru.lm359.shotclockbanking.dtos.auth;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthRequestDto {
    private String username;
    private String password;
}
