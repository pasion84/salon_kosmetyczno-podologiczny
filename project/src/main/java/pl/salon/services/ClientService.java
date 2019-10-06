package pl.salon.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import pl.salon.dto.EditClientFormDTO;
import pl.salon.dto.RegistrationFormDTO;
import pl.salon.model.Client;
import pl.salon.repositories.ClientRepository;

import java.util.List;

@Service
@Transactional
public class ClientService {

    private ClientRepository clientRepository;
    private PasswordEncoder passwordEncoder;


    public ClientService(ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    public List<Client> findAllWorkers(String role) {
        Client client = new Client();
        return clientRepository.findAllByRole(client.getRole());
    }

    public Client findClientById(Long id) {
        return clientRepository.findClientById(id);
    }

    public Client findClientByIdAndRoleWhereRoleIsUser(Long id) {
        return clientRepository.findClientOrderByIdAndRole(id, "ROLE-USER");
    }

    public Client findClientByIdAndRoleWhereRoleIsWorker(Long id) {
        return clientRepository.findClientOrderByIdAndRole(id, "ROLE-WORKER");
    }

    public Client findClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    public void editClient(EditClientFormDTO data, Long id) {
        Client client = clientRepository.findClientById(id);
        String encodedPassword = passwordEncoder.encode(data.getPassword());
        client.setEmail(data.getEmail());
        client.setFirstName(data.getFirstName());
        client.setLastName(data.getLastName());
        client.setPhoneNumber(data.getPhoneNumber());
        client.setNip(data.getNip());
        client.setRoleSet(data.getRole());
        client.setPassword(encodedPassword);
        client.setAddress(data.getAddress());
        client.setSalaryPerHour(data.getSalary());
        client.setStartingTime(data.getStartWork());
        client.setFinishingTime(data.getEndWork());
        clientRepository.save(client);
    }
}
