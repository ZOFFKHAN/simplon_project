package fr.mauritius.Backpacker.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.mauritius.Backpacker.domain.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> getById(Long id);

    void deleteByid(Long id);

    Optional<Customer> getByid(Long id);

}
