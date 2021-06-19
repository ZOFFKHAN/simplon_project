package fr.mauritius.Backpacker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.mauritius.Backpacker.domain.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByByDefaultTrue();

}
