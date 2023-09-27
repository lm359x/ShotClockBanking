package ru.lm359.shotclockbanking.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lm359.shotclockbanking.models.Role;
import ru.lm359.shotclockbanking.repo.RoleRepository;
import ru.lm359.shotclockbanking.service.RoleService;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;


    @Override
    public Role getRoleByName(String roleName) {
        return roleRepository.getRoleByRoleName(roleName);
    }
}
