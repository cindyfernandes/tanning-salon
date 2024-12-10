package tanningapp.tanning_salon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import tanningapp.tanning_salon.model.Client;
import tanningapp.tanning_salon.model.SessionHistory;
import tanningapp.tanning_salon.service.HistoryService;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private HistoryService historyService;

    // Serve the schedule session page
    @GetMapping
    public String showSchedulePage() {
        return "schedule_session";
    }

    // Handles booking a session
    @PostMapping("/book")
    public String bookSession(
            @ModelAttribute SessionHistory session,
            HttpSession httpSession) {
        // Retrieve the logged-in client from the session
        Client loggedInClient = (Client) httpSession.getAttribute("loggedInClient");

        if (loggedInClient == null) {
            System.out.println("No client found in session, redirecting to login.");
            return "redirect:/login";
        }

        // Set the client for the session and save it
        session.setClient(loggedInClient);
        session.setConfirmed(true);
        historyService.saveSession(session);

        return "redirect:/history?success=true"; // Redirect to the history page after booking
    }
}
