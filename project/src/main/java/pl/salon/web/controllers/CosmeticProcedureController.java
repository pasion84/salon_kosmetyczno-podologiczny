package pl.salon.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.salon.dto.CosmeticProcedureFormDTO;
import pl.salon.services.CosmeticProcedureService;

import javax.validation.Valid;

@Controller
@RequestMapping("/procedures")
public class CosmeticProcedureController {

    private CosmeticProcedureService cosmeticProcedureService;

    public CosmeticProcedureController(CosmeticProcedureService cosmeticProcedureService) {
        this.cosmeticProcedureService = cosmeticProcedureService;
    }

    @GetMapping
    public String prepareProceduresPage(Model model) {
        model.addAttribute("procedure", new CosmeticProcedureFormDTO());
        return "addCosmeticProcedure";
    }

    @PostMapping
    public String processProceduresPage(@ModelAttribute("procedure") @Valid CosmeticProcedureFormDTO cosmeticProcedureFormDTO, BindingResult result) {
        if (result.hasErrors()) return "addCosmeticProcedure";
        if (cosmeticProcedureFormDTO.getName().isEmpty()) {
            result.rejectValue("name", null, "pole name nie może być puste");
            result.rejectValue("price", null, "pole price nie może być puste");
            result.rejectValue("durationOfProcedure", null, "pole durationOfProcedure nie może być puste");
            return "addCosmeticProcedure";
        }
        cosmeticProcedureService.registerNewCosmeticProcedure(cosmeticProcedureFormDTO);
        return "redirect:/";
    }
}
