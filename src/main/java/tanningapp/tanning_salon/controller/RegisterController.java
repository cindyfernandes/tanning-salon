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
    private ClientRepository clientRepository;

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("client", new Client());
        return "register_page";
    }
    @PostMapping
    public String processRegistration(
        @Valid @ModelAttribute("client") Client client,
        BindingResult result,
        Model model) {

        if (result.hasErrors()) {
            logger.error("Validation errors: {}", result.getAllErrors());
            return "register_page";
        }

        // Additional validations
        if (clientRepository.findByEmail(client.getEmail()) != null) {
            model.addAttribute("emailError", "Email is already registered.");
            return "register_page";
        }

        // Set approval to false by default
        client.setApproved(false);

        // Save the client directly
        clientRepository.save(client);
        logger.info("Client saved: {}", client.getEmail());

        model.addAttribute("name", client.getFirstname() + " " + client.getLastname());
        return "register_success";
    }
}
