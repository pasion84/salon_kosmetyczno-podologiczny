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

    public void registerClient(RegistrationFormDTO data) {
        Client client = new Client();
        client.setEmail(data.getEmail());
        String encodedPassword = passwordEncoder.encode(data.getPassword());
        client.setPassword(encodedPassword);
        client.setFirstName(data.getFirstName());
        client.setLastName(data.getLastName());
        client.setPhoneNumber(data.getPhoneNumber());
        clientRepository.save(client);
    }
}
