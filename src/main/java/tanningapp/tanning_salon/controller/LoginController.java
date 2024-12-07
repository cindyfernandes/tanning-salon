package tanningapp.tanning_salon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import tanningapp.tanning_salon.model.Client;
import tanningapp.tanning_salon.model.Staff;
import tanningapp.tanning_salon.repository.ClientRepository;
import tanningapp.tanning_salon.repository.StaffRepository;

@Controller
public class LoginController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private StaffRepository staffRepository;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session,
            Model model) {

        // Check if the user is an staff
        Staff staff = staffRepository.findByUsername(email);
        if (staff != null && staff.getPassword().equals(password)) {
            // Redirect to approve clients page for staff
            return "redirect:/approveClients";
        }

        // Check if the user is a client
        Client client = clientRepository.findByEmail(email);
        if (client != null && client.getPassword().equals(password)) {
            if (!client.isApproved()) {
                // If the client is not approved, show an error on the login page
                model.addAttribute("error", "Your account is not approved yet.Please contact support.");
                return "login";
            }

            // Save client to session
            session.setAttribute("loggedInClient", client);
            System.out.println("Client logged in: " + client.getEmail());
            
            // Redirect to client home page
            return "redirect:/clientHome";
        }

        // Invalid login
        model.addAttribute("error", "Invalid email or password");
        return "login";
    }
}