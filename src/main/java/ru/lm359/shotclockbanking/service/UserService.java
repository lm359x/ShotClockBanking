package ru.lm359.shotclockbanking.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.lm359.shotclockbanking.dtos.create.CreateUserDto;
import ru.lm359.shotclockbanking.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    User createUser(CreateUserDto user);
    User getUserById(Long userId);
    List<User> getAllUsers();
    User updateUser(User user);
    void deleteUser(Long userId);
    User findByUsername(String username);

}
