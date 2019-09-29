package pl.salon.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.salon.dto.CosmeticProcedureFormDTO;
import pl.salon.services.CosmeticProcedureService;
import pl.salon.services.RegistrationService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping({"/procedures", "/admin/procedures"})
public class CosmeticProcedureController {

    private CosmeticProcedureService cosmeticProcedureService;
    private RegistrationService registrationService;

    public CosmeticProcedureController(CosmeticProcedureService cosmeticProcedureService, RegistrationService registrationService) {
        this.cosmeticProcedureService = cosmeticProcedureService;
        this.registrationService = registrationService;
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
        model.addAttribute("deleteProcedure", cosmeticProcedureService.findCosmeticProcedureById(id));
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
}
