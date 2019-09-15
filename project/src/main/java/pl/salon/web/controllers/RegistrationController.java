package pl.salon.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.salon.dto.RegistrationFormDTO;
import pl.salon.services.RegistrationService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String prepareRegistrationPage(Model model) {
        model.addAttribute("data", new RegistrationFormDTO());
        return "registration";
    }

    @PostMapping
    public String processRegistrationPage(@ModelAttribute("data") @Valid RegistrationFormDTO data, BindingResult result) {
        if (result.hasErrors()) return "registration";
        if (!data.getPassword().equals(data.getRePassword())) {
            result.rejectValue("rePassword", null, "password and re password have to be match");
            return "registration";
        }
        if (!registrationService.isEmailAvailable(data.getEmail())) {
            result.rejectValue("email", null, "email jest zajęty");
            return "registration";
        }
        registrationService.registerClient(data);
        return "redirect:/login";
    }
}

