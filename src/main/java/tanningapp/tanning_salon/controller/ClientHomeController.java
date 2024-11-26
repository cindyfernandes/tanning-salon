package tanningapp.tanning_salon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tanningapp.tanning_salon.model.Client;
import tanningapp.tanning_salon.repository.ClientRepository;

import javax.servlet.http.HttpSession;

@Controller
public class ClientHomeController {

    @Autowired
    private ClientRepository clientRepository;
    @GetMapping("/clientHome")
    public String showClientHome(HttpSession session, Model model) {
        // Retrieve the logged-in client's from the session
        Client client = (Client) session.getAttribute("loggedInClient");

        if (client != null) {
            // Add the client's name to the model
            model.addAttribute("clientName", client.getFirstname());
        } else {
            // Redirect to login if no client is logged in
            return "redirect:/login";
        }
    
        return "client_home"; // Return the view name for the client home page

    }

    /**
     * Directs the client to the booking page.
     */
    @GetMapping("/schedule")
    public String showSchedulePage() {
        return "schedule"; 
    }

    /**
     * Directs the client to the session history page.
     */
    @GetMapping("/history")
    public String showHistoryPage() {
        return "history"; 
    }

    /**
     * Directs the client to the skincare tips page.
     */
    @GetMapping("/skincare-tips")
    public String showSkincareTipsPage() {
        return "skincare_tips"; 
    }
}
