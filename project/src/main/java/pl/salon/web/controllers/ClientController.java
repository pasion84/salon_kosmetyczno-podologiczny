package pl.salon.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.salon.repositories.ClientRepository;


@Controller
@RequestMapping("/client")
public class ClientController {
    private ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public String prepareFindAllClients(Model model) {
        model.addAttribute("allClients", clientRepository.findAll());
        return "clientList";
    }
}
