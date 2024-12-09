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
    private SkincareRepository skincareTipRepository;

    // Método GET para carregar o template HTML
    @GetMapping("/skincareTips")
    public String showSkincarePage() {
        return "skincare_tips"; // Nome do arquivo HTML em src/main/resources/templates (sem extensão)
    }

    // Método POST para processar a requisição e retornar os dados
    @PostMapping("/skincareTips/advice")
    public String getSkincareTips(@RequestParam String skinTone, Model model) {
        SkincareTip tip = skincareTipRepository.findBySkinTone(skinTone);
        model.addAttribute("tip", tip);
        return "skincare_tips"; // Retorna o mesmo template com os dados incluídos
    }
}