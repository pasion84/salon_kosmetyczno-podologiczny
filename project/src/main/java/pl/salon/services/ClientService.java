package pl.salon.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.salon.model.Client;
import pl.salon.repositories.ClientRepository;

import java.util.List;

@Service
@Transactional
public class ClientService {
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    private ClientRepository clientRepository;

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }
}
