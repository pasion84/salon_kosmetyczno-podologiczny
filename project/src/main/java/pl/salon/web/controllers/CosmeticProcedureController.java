package pl.salon.web.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.salon.dto.CosmeticProcedureFormDTO;
import pl.salon.dto.LoginFormDTO;
import pl.salon.dto.PlannedProcedureDTO;
import pl.salon.dto.RegistrationFormDTO;
import pl.salon.model.Client;
import pl.salon.repositories.ClientRepository;
import pl.salon.services.ClientService;
import pl.salon.services.CosmeticProcedureService;
import pl.salon.services.RegistrationService;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping({"/procedures", "/admin/procedures"})
public class CosmeticProcedureController {

    private CosmeticProcedureService cosmeticProcedureService;
    private RegistrationService registrationService;
    private ClientRepository clientRepository;
    private ClientService clientService;

    public CosmeticProcedureController(CosmeticProcedureService cosmeticProcedureService, RegistrationService registrationService, ClientRepository clientRepository, ClientService clientService) {
        this.cosmeticProcedureService = cosmeticProcedureService;
        this.registrationService = registrationService;
        this.clientRepository = clientRepository;
        this.clientService = clientService;
    }

    @ModelAttribute("principal")
    public Client principalToClient() {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        return clientService.findClientByEmail(principal.getName());
    }

    @GetMapping("create")
    public String prepareProceduresPage(Model model) {
        model.addAttribute("procedure", new CosmeticProcedureFormDTO());
        return "addCosmeticProcedure";
    }

    @PostMapping("create")
    public String processProceduresPage(@ModelAttribute("procedure") @Valid CosmeticProcedureFormDTO cosmeticProcedureFormDTO, BindingResult result) {
        if (result.hasErrors()) return "addCosmeticProcedure";
        if (cosmeticProcedureFormDTO.getName().isEmpty()) {
            result.rejectValue("name", null, "pole name nie może być puste");
            return "addCosmeticProcedure";
        }
        if (cosmeticProcedureFormDTO.getPrice() == null) {
            result.rejectValue("price", null, "pole price nie może być puste");
            return "addCosmeticProcedure";
        }
        if (cosmeticProcedureFormDTO.getDurationOfProcedureInMinutes() == null) {
            result.rejectValue("durationOfProcedure", null, "pole durationOfProcedure nie może być puste");
            return "addCosmeticProcedure";
        }
        cosmeticProcedureService.registerNewCosmeticProcedure(cosmeticProcedureFormDTO);
        return "redirect:/";
    }

    @GetMapping("delete")
    public String prepareDeleteProcedurePage(Model model, Long id) {
        model.addAttribute("deleteProcedure", cosmeticProcedureService.findById(id));
        return "deleteCosmeticProcedure";
    }

    @GetMapping("deleteProcedure")
    public String processDeleteProcedurePage(Long id) {
        cosmeticProcedureService.deleteCosmeticProcedureById(id);
        return "redirect:/";
    }

    @GetMapping
    public String prepareProcedureListPage(Model model, Principal principal) {
        model.addAttribute("procedureList", cosmeticProcedureService.findAllCosmeticProcedures());
        if (registrationService.isAdmin(principal.getName())) {
            return "adminCosmeticProcedures";
        }
        return "cosmeticProcedures";
    }

    @GetMapping("add")
    public String preparePlanNewProcedureForClient(Model model, @RequestParam(required = false) Long id, Principal principal) {
        model.addAttribute("addClientProcedure", new PlannedProcedureDTO());
        model.addAttribute("procedureList", cosmeticProcedureService.findAllCosmeticProcedures());
        model.addAttribute("allWorkers", clientRepository.findAllByRole("ROLE_WORKER"));
        model.addAttribute("clientService", clientService.findClientByEmail(principal.getName()));
        model.addAttribute("client", clientService.findClientByIdAndRoleWhereRoleIsUser(id));
        return "addProcedureToClient";
    }

    @PostMapping("add")
    public String processPlanNewProcedureForClient(@ModelAttribute("plannedProcedureDTO") @Valid PlannedProcedureDTO plannedProcedureDTO, @RequestParam(required = false) Long id, Principal principal) {
        cosmeticProcedureService.addNewPlannedProcedureForClient(plannedProcedureDTO, principal.getName());
        return "redirect:/";
    }

}
