package ru.lm359.shotclockbanking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lm359.shotclockbanking.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
}
