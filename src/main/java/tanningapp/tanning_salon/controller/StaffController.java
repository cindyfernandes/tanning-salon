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
    private ClientRepository clientRepository;

    @Autowired
    private EmailService emailService; // Inject EmailService

    @GetMapping("/approveClients")
    public String showPendingClients(Model model) {
        
        // Fetch clients where approved is false
        List<Client> pendingClients = clientRepository.findByApproved(false);
        model.addAttribute("pendingClients", pendingClients);
        return "approve_clients";
    }

    @PostMapping("/approveClient")
    public String approveClient(@RequestParam Long clientId, Model model) {

        // Fetch client from the database
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new IllegalArgumentException("Invalid client ID"));

        // Approve the client and save the changes to the database
        client.setApproved(true);
        clientRepository.save(client);

        // Send an email to the client with approval information
        emailService.sendApprovalEmail(client.getEmail(), client.getFirstname() + " " + client.getLastname());
        
        model.addAttribute("successMessage", "Client approved successfully.");
        return "redirect:/approveClients";
    }

    @PostMapping("/rejectClient")
    public String rejectClient(@RequestParam Long clientId, Model model) {
        clientRepository.deleteById(clientId);
        model.addAttribute("successMessage", "Client rejected successfully.");
        return "redirect:/approveClients";
    }
}
