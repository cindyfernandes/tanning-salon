package tanningapp.tanning_salon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class LocationController {

    @GetMapping("/location")
    public String testSuccess(Model model) {
        return "store_locator"; 
    }
}
