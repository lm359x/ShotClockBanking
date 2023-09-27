package ru.lm359.shotclockbanking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lm359.shotclockbanking.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role getRoleByRoleName(String roleName);
}
