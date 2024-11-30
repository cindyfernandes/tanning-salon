package tanningapp.tanning_salon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScheduleController {

    @GetMapping("/schedule")
    public String showSchedulePage() {
        return "schedule_session"; 
    }
    
}
