package pl.salon.web.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.salon.dto.EditClientFormDTO;
import pl.salon.dto.RegistrationFormDTO;
import pl.salon.model.Client;
import pl.salon.repositories.ClientRepository;
import pl.salon.services.ClientService;
import pl.salon.services.CosmeticProcedureService;

import javax.validation.Valid;
import java.security.Principal;


@Controller
@RequestMapping("/client")
public class ClientController {
    private ClientRepository clientRepository;
    private ClientService clientService;

    public ClientController(ClientRepository clientRepository, ClientService clientService) {
        this.clientRepository = clientRepository;
        this.clientService = clientService;
    }

    @ModelAttribute("principal")
    public Client principalToClient() {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        return clientService.findClientByEmail(principal.getName());
    }

    @GetMapping
    public String prepareFindAllClients(Model model) {
        model.addAttribute("allClients", clientRepository.findAll());
        return "clientList";
    }

    @GetMapping("/workers")
    public String prepareFindAllWorkers(Model model) {
        model.addAttribute("allWorkers", clientRepository.findAllByRole("ROLE_WORKER"));
        return "workerList";
    }

    @GetMapping("edit")
    public String prepareEditClient(Model model, @RequestParam(required = false) Long id) {
        Client client = clientService.findClientById(id);
        model.addAttribute("editClient", client);
        return "editClient";
    }

    @PostMapping("edit")
    public String processEditClient(@ModelAttribute("editClient") @Valid EditClientFormDTO data, @RequestParam(required = false) Long id) {
        clientService.editClient(data, id);
        return "redirect:/";
    }

}
