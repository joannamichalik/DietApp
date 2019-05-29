package pl.atm.dietapp.dietapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.atm.dietapp.dietapp.dto.UserDto;
import pl.atm.dietapp.dietapp.entity.User;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class LoginController {

    @RequestMapping("login")
    public String loginForm(Principal principal) {
        if(principal != null){
            return "redirect:/index";
        }

        return "login";
    }


//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(Principal principal){
//
//        if(principal == null){
//            return "/index";
//        }
//        return "caloriescalc";
//    }
}
