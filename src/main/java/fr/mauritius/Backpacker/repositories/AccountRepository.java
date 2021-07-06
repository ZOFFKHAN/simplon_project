package fr.mauritius.Backpacker.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.mauritius.Backpacker.domain.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

    // boolean existsByemail(String value);
    // boolean existsByEmail(String email);

    // Optional<Account> findByEmailAndEnabledTrue(String value);
    boolean existsByUsername(String username);

    Account findByUsername(String username);

    Optional<Account> findByUsernameAndEnabledTrue(String username);

}
