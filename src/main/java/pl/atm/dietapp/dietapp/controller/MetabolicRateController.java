package pl.atm.dietapp.dietapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.atm.dietapp.dietapp.dto.MetabolicRate;

@Controller
public class MetabolicRateController {

    @GetMapping("bmr")
    public String metabolicRateForm(Model model) {
        model.addAttribute("metabolicRate", new MetabolicRate());

        return "bmr";
    }

    @PostMapping("bmr")
    public String metabolicRateSubmit(@ModelAttribute MetabolicRate metabolicRate) {
        return "bmr";
    }


}
