package ru.lm359.shotclockbanking.controller;

import org.springframework.web.bind.annotation.*;
import ru.lm359.shotclockbanking.dtos.create.CreateUserDto;
import ru.lm359.shotclockbanking.models.User;
import ru.lm359.shotclockbanking.service.RoleService;
import ru.lm359.shotclockbanking.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostMapping
    public User createUser(@RequestBody CreateUserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user) {
        user.setUserId(userId);
        return userService.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
