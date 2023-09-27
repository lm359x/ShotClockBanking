package ru.lm359.shotclockbanking.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import ru.lm359.shotclockbanking.dtos.auth.AuthRequestDto;
import ru.lm359.shotclockbanking.dtos.auth.RegistrationRequestDto;

public interface AuthService {
    ResponseEntity<?> createAuthToken(@RequestBody AuthRequestDto authRequestDto);
    ResponseEntity<?> createNewUser(@RequestBody RegistrationRequestDto registrationDto);
}
