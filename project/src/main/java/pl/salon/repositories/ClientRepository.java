package pl.salon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.salon.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Long countByEmail(String email);
}

