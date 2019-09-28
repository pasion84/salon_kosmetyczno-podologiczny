package pl.salon.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.salon.dto.RegistrationFormDTO;
import pl.salon.model.Client;
import pl.salon.repositories.ClientRepository;

@Service
@Transactional
public class RegistrationService {

    private ClientRepository clientRepository;
    private PasswordEncoder passwordEncoder;

    public RegistrationService(ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean isEmailAvailable(String email) {
        Long count = clientRepository.countByEmail(email);
        if (count > 0) {
            return false;
        } else return true;
    }

    public boolean isAdmin(String email) {
        return clientRepository.findByEmail(email).getRole().equals("ROLE_ADMIN") ? true : false;
    }

    public void registerClient(RegistrationFormDTO data) {
        Client client = new Client();
        client.setEmail(data.getEmail());
        String encodedPassword = passwordEncoder.encode(data.getPassword());
        String encodedRePassword = passwordEncoder.encode(data.getRePassword());
        client.setPassword(encodedPassword);
        client.setPassword(encodedRePassword);
        client.setFirstName(data.getFirstName());
        client.setLastName(data.getLastName());
        client.setPhoneNumber(data.getPhoneNumber());
        client.setNip(data.getNip());
        client.setRoleSet(data.getRole());
        clientRepository.save(client);
    }
}
