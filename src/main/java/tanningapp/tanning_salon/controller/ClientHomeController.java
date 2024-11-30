package tanningapp.tanning_salon.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import tanningapp.tanning_salon.model.Client;

@Controller
public class ClientHomeController {

    @GetMapping("/clientHome")
    public String showClientHome(
        HttpSession session,
        Model model
    ) {
        // Retrieve the logged-in client's from the session
        Client loggedInClient = (Client) session.getAttribute("loggedInClient");

        if (loggedInClient == null) {
            // Redirect to login if no client is authenticated
            return "redirect:/login";
        }

        // Add the client's name to the model
        model.addAttribute("firstname", loggedInClient.getFirstname());

        // Render the client home page
        return "client_home";

    }

}
