package pl.salon.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.salon.dto.PlannedProcedureDTO;
import pl.salon.model.Client;
import pl.salon.model.CosmeticProcedure;
import pl.salon.repositories.ClientRepository;
import pl.salon.services.ClientService;
import pl.salon.services.CosmeticProcedureService;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/plannedProcedure")
public class PlannedProceduresController {

    private ClientService clientService;
    private ClientRepository clientRepository;
    private CosmeticProcedureService cosmeticProcedureService;

    public PlannedProceduresController(ClientService clientService, ClientRepository clientRepository, CosmeticProcedureService cosmeticProcedureService) {
        this.clientService = clientService;
        this.clientRepository = clientRepository;
        this.cosmeticProcedureService = cosmeticProcedureService;
    }

    //    do poprawy
    @ModelAttribute("cosmeticProcedureList")
    public List<CosmeticProcedure> getCosmeticProcedureList() {
        List<CosmeticProcedure> cosmeticProcedureList = new ArrayList<>();
        cosmeticProcedureList.addAll(cosmeticProcedureService.findAllCosmeticProcedures());
        return cosmeticProcedureList;
    }

    @ModelAttribute("workerList")
    public List<Client> getWorkerList() {
        List<Client> clientList = new ArrayList<>();
        clientList.addAll(clientRepository.findAllByRole("ROLE_WORKER"));
        return clientList;
    }

    @GetMapping("planProcedureToClient")
    public String preparePlanNewProcedureForClient(Model model, Principal principal) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        model.addAttribute("actualTime", LocalDateTime.now().format(inputFormatter));
        model.addAttribute("addClientProcedure", new PlannedProcedureDTO());
        model.addAttribute("procedureList", getCosmeticProcedureList());
        model.addAttribute("allWorkers", getWorkerList());
        model.addAttribute("clientService", clientService.findClientByEmail(principal.getName()));
        return "addProcedureToClient";
    }


    @PostMapping("planProcedureToClient")
    public String processPlanNewProcedureForClient(@ModelAttribute("addClientProcedure") @Valid PlannedProcedureDTO plannedProcedureDTO, Principal principal) {

        cosmeticProcedureService.addNewPlannedProcedureForClient(plannedProcedureDTO, principal.getName());
        return "redirect:/";
    }

    @GetMapping("viewPlannedProceduresForClient")
    public String prepareViewPannedProcedurePageForClient(Model model, Principal principal) {
        model.addAttribute("viewPlannedProceduresForClient", cosmeticProcedureService.findAllPlannedProceduresForClient(principal.getName()));
        return "listOfPlannedProceduresForClient";
    }
}
