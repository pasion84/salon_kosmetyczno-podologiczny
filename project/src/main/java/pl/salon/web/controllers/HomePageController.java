package pl.salon.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.salon.services.RegistrationService;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequestMapping({"/", "/admin"})
public class HomePageController {
    public RegistrationService registrationService;

    public HomePageController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String prepareHomePage(Model model, Principal principal, HttpSession session) {
        String clientname = principal.getName();
        session.setAttribute("User", principal);
        model.addAttribute("clientname", clientname);
        if (registrationService.isAdmin(principal.getName())) {
            return "admin";
        }
        return "index";
    }

}
