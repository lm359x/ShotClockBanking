package ru.lm359.shotclockbanking.service;

import ru.lm359.shotclockbanking.models.Role;

public interface RoleService {
    Role getRoleByName(String roleName);
}
