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
    private ClientRepository clientRepository; // Repository for handling client data

    @Autowired
    private StaffRepository staffRepository; // Repository for handling staff data

    // Display the login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // Process login form submissions
    @PostMapping("/login")
    public String processLogin(
            @RequestParam String email, // Email entered by the user
            @RequestParam String password, // Password entered by the user
            HttpSession session, // To manage session data
            Model model // To pass data to the view
    ) {

        // Check if the user is a staff member
        Staff staff = staffRepository.findByUsername(email);
        if (staff != null && staff.getPassword().equals(password)) {
            // Redirect staff to the approve clients page
            return "redirect:/approveClients";
        }

        // Check if the user is a client
        Client client = clientRepository.findByEmail(email);
        if (client != null && client.getPassword().equals(password)) {
            if (!client.isApproved()) {
                // If the client account is not approved, show an error message
                model.addAttribute("error", "Your account is not approved yet. Please contact support.");
                return "login";
            }

            // Store the logged-in client in the session
            session.setAttribute("loggedInClient", client);
            System.out.println("Client logged in: " + client.getEmail());

            // Redirect to the client home page
            return "redirect:/clientHome";
        }

        // If login credentials are invalid, show an error message
        model.addAttribute("error", "Invalid email or password");
        return "login";
    }
}
