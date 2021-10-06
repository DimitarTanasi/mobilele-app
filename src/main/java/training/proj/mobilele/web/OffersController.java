package training.proj.mobilele.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import training.proj.mobilele.services.OffersService;

@Controller
@RequestMapping("/offers")
public class OffersController {


    private final OffersService offersService;

    public OffersController(OffersService offersService) {
        this.offersService = offersService;
    }

    @GetMapping("/all")
    public String allOffers(Model model){
        model.addAttribute("offers",offersService.getAllOffers());
        return "offers";
    }
}
