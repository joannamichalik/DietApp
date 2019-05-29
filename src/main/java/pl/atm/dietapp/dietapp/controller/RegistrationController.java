package pl.atm.dietapp.dietapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import pl.atm.dietapp.dietapp.dto.UserDto;
import pl.atm.dietapp.dietapp.exception.RegistrationException;
import pl.atm.dietapp.dietapp.service.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String getRegistrationForm(Model model, Principal principal){
        model.addAttribute("user", new UserDto());
        if(principal != null){
            return "redirect:/index";
        }

        return "register";
    }

    // public String registerNewUser(@ModelAttribute(“user”) UserDTO userDto, BindingResult result, WebRequest request, Model model) { … }
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("user") UserDto user, BindingResult result, Model model){
        try {
            userService.save(user);
        } catch (RegistrationException e) {
            model.addAttribute("error",e.getMessage() + user.getUsername());
            return "register";
        }
        return "redirect:login";

        /*
       User registeredUser = new User();
String userName = userDto.getUserName();
if (result.hasErrors()) {
    return “registration”;
}
registeredUser = service.findByUsername(userName);
if(registeredUser!=null) {
    model.addAttribute(“error”,”There is already an account with this username: “ + userName);
    return “registration”;
}
registeredUser = service.registerUser(userDto);
         */

//        } else {
//            try {
//                userService.save(user);
//            } catch (RegistrationException e) {
//                model.addAttribute("error", "Error: " + e.getMessage());
//                return "register";
//            }
//            return "redirect:products";
//        }


    }
}
