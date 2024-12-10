package tanningapp.tanning_salon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tanningapp.tanning_salon.model.SkincareTip;
import tanningapp.tanning_salon.repository.SkincareRepository;

@Controller
public class SkincareController {

    @Autowired
    private SkincareRepository skincareTipRepository; // Repository for managing skincare tips

    // GET method to load the HTML template for skincare tips
    @GetMapping("/skincareTips")
    public String showSkincarePage() {
        return "skincare_tips"; // Name of the HTML file in src/main/resources/templates (without extension)
    }

    // POST method to process the request and return data
    @PostMapping("/skincareTips/advice")
    public String getSkincareTips(
            @RequestParam String skinTone, // Skin tone provided by the user
            Model model // Used to pass data to the view
    ) {
        // Retrieve skincare tip based on the skin tone
        SkincareTip tip = skincareTipRepository.findBySkinTone(skinTone);

        // Add the retrieved tip to the model
        model.addAttribute("tip", tip);

        // Return the same template with the data included
        return "skincare_tips";
    }
}
