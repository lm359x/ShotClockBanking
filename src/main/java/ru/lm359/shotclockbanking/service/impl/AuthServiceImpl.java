package ru.lm359.shotclockbanking.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.lm359.shotclockbanking.controller.exception.AuthException;
import ru.lm359.shotclockbanking.controller.exception.RegistrationError;
import ru.lm359.shotclockbanking.dtos.auth.AuthRequestDto;
import ru.lm359.shotclockbanking.dtos.auth.AuthResponseDto;
import ru.lm359.shotclockbanking.dtos.auth.RegistrationRequestDto;
import ru.lm359.shotclockbanking.dtos.create.CreateUserDto;
import ru.lm359.shotclockbanking.dtos.get.GetUserDto;
import ru.lm359.shotclockbanking.models.Customer;
import ru.lm359.shotclockbanking.models.User;
import ru.lm359.shotclockbanking.service.AuthService;
import ru.lm359.shotclockbanking.service.CustomerService;
import ru.lm359.shotclockbanking.service.UserService;
import ru.lm359.shotclockbanking.utils.JwtTokenUtils;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService  {
    private final UserService userService;
    private final JwtTokenUtils jwtTokenUtils;
    private final AuthenticationManager authenticationManager;
    private final CustomerService customerService;


    public ResponseEntity<?> createAuthToken(@RequestBody AuthRequestDto authRequestDto){
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequestDto.getUsername(), authRequestDto.getPassword()));
        }catch(AuthenticationException e){
            throw new AuthException("Incorrect login pass");
        }
        UserDetails userDetails = userService.loadUserByUsername(authRequestDto.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponseDto(token));
    }

    public ResponseEntity<?> createNewUser(@RequestBody RegistrationRequestDto registrationDto){
        if(userService.findByUsername(registrationDto.getUsername())!=null)
            throw new RegistrationError("Username is taken");
        CreateUserDto userDto = new CreateUserDto(registrationDto.getUsername(), registrationDto.getPassword(),"ROLE_USER");
        User user = userService.createUser(userDto);
        Customer customer = new Customer(
                registrationDto.getFirstName(),
                registrationDto.getLastName(),
                registrationDto.getAddress(),
                registrationDto.getContactDetails(),
                user);
        customerService.createCustomer(customer);
        return ResponseEntity.ok(new GetUserDto(user.getUserId(), userDto.getUsername()));
    }
}
