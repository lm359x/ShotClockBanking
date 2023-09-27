package ru.lm359.shotclockbanking.dtos.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegistrationRequestDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String contactDetails;
}
