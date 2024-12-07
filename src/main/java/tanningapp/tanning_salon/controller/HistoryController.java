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
    private HistoryService historyService;

    @GetMapping("/history")
    public String getSessionHistory(HttpSession httpSession, Model model, @RequestParam(required = false) String success) {
        // Retrieve the logged-in client from the session
        Client loggedInClient = (Client) httpSession.getAttribute("loggedInClient");

        if (loggedInClient == null) {
            // Redirect to login if no client is authenticated
            return "redirect:/login";
        }

        // Retrieve the session history for the client
        model.addAttribute("sessionList", historyService.getSessionHistoryForClient(loggedInClient));

        // Add success message if present
        if ("true".equals(success)) {
            model.addAttribute("successMessage", "Session booked successfully!");
        }

        // Render the history page
        return "view_history";
    }
}
