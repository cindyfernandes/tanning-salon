package tanningapp.tanning_salon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import tanningapp.tanning_salon.model.Client;
import tanningapp.tanning_salon.service.HistoryService;

@Controller
public class HistoryController {

    @Autowired
    private HistoryService historyService; // Service to handle session history logic

    // Maps GET requests to the "/history" endpoint
    @GetMapping("/history")
    public String getSessionHistory(
            HttpSession httpSession, // Used to access session data
            Model model, // Used to pass data to the view
            @RequestParam(required = false) String success // Optional request parameter for success messages
    ) {
        // Retrieve the logged-in client from the session
        Client loggedInClient = (Client) httpSession.getAttribute("loggedInClient");

        if (loggedInClient == null) {
            // Redirect to the login page if no client is authenticated
            return "redirect:/login";
        }

        // Retrieve the session history for the logged-in client and add it to the model
        model.addAttribute("sessionList", historyService.getSessionHistoryForClient(loggedInClient));

        // If a success message is provided, add it to the model
        if ("true".equals(success)) {
            model.addAttribute("successMessage", "Session booked successfully!");
        }

        // Return the name of the view for the history page
        return "view_history";
    }
}
