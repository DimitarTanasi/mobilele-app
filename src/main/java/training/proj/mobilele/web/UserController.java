package training.proj.mobilele.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import training.proj.mobilele.models.binding.UserRegisterBingingModel;
import training.proj.mobilele.models.service.UserRegistrationServiceModel;
import training.proj.mobilele.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login(){
        return "auth-login";
    }

    @PostMapping("/login-err")
    public ModelAndView badCredentials(@ModelAttribute("username")String username,
                                       @ModelAttribute("password")String password){

        ModelAndView model = new ModelAndView();
        model
                .addObject("bad_credentials",true)
                .addObject("inputusername",username)
                .setViewName("/auth-login");

        return model;

    }

    @ModelAttribute("userRegisterBindingModel")
    public UserRegisterBingingModel createBindingModel(){
        return new UserRegisterBingingModel();
    }
    @GetMapping("/register")
    public String register(){
        return "auth-register";
    }

    @PostMapping("/register")
    public String registerConfirm(UserRegisterBingingModel bingingModel,
                                  RedirectAttributes redirectAttributes){

        if (userService.userNameExists(bingingModel.username)){
            redirectAttributes.addFlashAttribute("userExistsError",true);
            redirectAttributes.addFlashAttribute("registrationBindingModel",bingingModel);
            return "redirect:/users/register";
        }

        UserRegistrationServiceModel userServiceModel = modelMapper.map(bingingModel,UserRegistrationServiceModel.class);

        userService.registerUser(userServiceModel);

        return "redirect:/users/login";
    }

}
