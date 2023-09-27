package ru.lm359.shotclockbanking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lm359.shotclockbanking.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
