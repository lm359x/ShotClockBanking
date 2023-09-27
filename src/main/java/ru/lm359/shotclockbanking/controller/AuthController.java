package ru.lm359.shotclockbanking.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.lm359.shotclockbanking.dtos.auth.AuthRequestDto;
import ru.lm359.shotclockbanking.dtos.auth.RegistrationRequestDto;
import ru.lm359.shotclockbanking.service.AuthService;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody AuthRequestDto authRequestDto){
        return authService.createAuthToken(authRequestDto);
    }

    @PostMapping("/registration")
    public ResponseEntity<?> createNewUser(@RequestBody RegistrationRequestDto registrationDto){
        return authService.createNewUser(registrationDto);
    }
}
