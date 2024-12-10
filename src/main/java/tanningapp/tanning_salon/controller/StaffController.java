package tanningapp.tanning_salon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tanningapp.tanning_salon.model.Client;
import tanningapp.tanning_salon.repository.ClientRepository;
import tanningapp.tanning_salon.service.EmailService;

@Controller
public class StaffController {

    @Autowired
    private ClientRepository clientRepository; // Repository for managing client data

    @Autowired
    private EmailService emailService; // Service for sending emails

    // GET method to show clients pending approval
    @GetMapping("/approveClients")
    public String showPendingClients(Model model) {
        // List clients whose approval status is false
        List<Client> pendingClients = clientRepository.findByApproved(false);
        model.addAttribute("pendingClients", pendingClients); // Add pending clients to the model
        return "approve_clients"; // Render the approval page
    }

    // POST method to approve a client
    @PostMapping("/approveClient")
    public String approveClient(
        @RequestParam Long clientId, // Client ID from the request
        Model model // Model to pass messages to the view
    ) {
        // Find client from the database
        Client client = clientRepository.findById(clientId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid client ID"));

        // Approve the client and save changes
        client.setApproved(true);
        clientRepository.save(client);

        // Send an approval email to the client
        emailService.sendApprovalEmail(client.getEmail(), client.getFirstname() + " " + client.getLastname());

        model.addAttribute("successMessage", "Client approved successfully."); // Add success message
        return "redirect:/approveClients"; // Redirect back to the approval page
    }

    // POST method to reject a client
    @PostMapping("/rejectClient")
    public String rejectClient(
        @RequestParam Long clientId, // Client ID from the request
        Model model // Model to pass messages to the view
    ) {
        // Delete the client from the database
        clientRepository.deleteById(clientId);

        model.addAttribute("successMessage", "Client rejected successfully."); // Add success message
        return "redirect:/approveClients"; // Redirect back to the approval page
    }

    // GET method to handle client search functionality
    @GetMapping("/searchClients")
    public String searchClients(
        @RequestParam String query, // Search query provided by the user
        Model model // Model to pass search results to the view
    ) {
        // Search for clients based on first name, last name, or email
        List<Client> searchResults = clientRepository
            .findByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCaseOrEmailContainingIgnoreCase(query, query, query);

        model.addAttribute("pendingClients", searchResults); // Add search results to the model
        return "approve_clients"; 
    }
}
