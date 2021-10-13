package training.proj.mobilele.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model){
       return "index";
    }

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal Principal principal, Model model){
        return "index";

    }
    @GetMapping("/access-denied")
    public String denied(){
        return "access-denied";
    }

}
