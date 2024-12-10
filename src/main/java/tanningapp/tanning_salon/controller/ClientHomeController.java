package tanningapp.tanning_salon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import tanningapp.tanning_salon.model.Client;

@Controller
public class ClientHomeController {

    // Maps GET requests to the "/clientHome" endpoint
    @GetMapping("/clientHome")
    public String showClientHome(
        HttpSession session, // Used to access session data
        Model model // Used to pass data to the view
    ) {
        // Retrieve the logged-in client from the session
        Client loggedInClient = (Client) session.getAttribute("loggedInClient");

        if (loggedInClient == null) {
            // Redirect to the login page if no client is authenticated
            return "redirect:/login";
        }

        // Add the client's first name to the model for display in the view
        model.addAttribute("firstname", loggedInClient.getFirstname());

        // Return the name of the view for the client's home page
        return "client_home";
    }
}
