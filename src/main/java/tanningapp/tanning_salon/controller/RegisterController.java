package tanningapp.tanning_salon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import tanningapp.tanning_salon.model.Client;
import tanningapp.tanning_salon.repository.ClientRepository;

@Controller
@RequestMapping("/registerpage")
public class RegisterController {

    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private ClientRepository clientRepository; // Repository for managing client data

    // GET requests to show the registration form
    @GetMapping
    public String showRegistrationForm(Model model) {
        // Add an empty Client object to the model for form binding
        model.addAttribute("client", new Client());
        return "register_page"; // Show the registration form page
    }

    // POST requests to process the registration form
    @PostMapping
    public String processRegistration(
        @Valid @ModelAttribute("client") Client client, // Bind and validate the Client object
        BindingResult result, // Holds validation results
        Model model // Used to pass data to the view
    ) {
        // If validation errors are present, return to the registration page
        if (result.hasErrors()) {
            logger.error("Validation errors: {}", result.getAllErrors());
            return "register_page";
        }

        // Check if the email is already registered
        if (clientRepository.findByEmail(client.getEmail()) != null) {
            model.addAttribute("emailError", "Email is already registered.");
            return "register_page";
        }

        // Set approval status to false by default for new clients
        client.setApproved(false);

        // Save the client in the repository
        clientRepository.save(client);
        logger.info("Client saved: {}", client.getEmail());

        // Add the client's name to the model for the success page
        model.addAttribute("name", client.getFirstname() + " " + client.getLastname());
        return "register_success"; // Render the registration success page
    }
}
