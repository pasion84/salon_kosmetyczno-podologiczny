package pl.salon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.salon.model.Client;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Long countByEmail(String email);

    List<Client> findAll();

    Client findByEmail(String email);

    List<Client> findAllByRole(String role);

    Client findClientById(Long id);

    Client findClientOrderByIdAndRole(Long id, String role);
}

