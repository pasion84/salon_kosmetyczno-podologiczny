package pl.salon.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequestMapping("/")
public class HomePageController {

    @GetMapping
    public String prepareHomePage(Model model, Principal principal, HttpSession session) {
        String clientname = principal.getName();
        session.setAttribute("User", principal);
        model.addAttribute("clientname", clientname);
        return "index";
    }
}
