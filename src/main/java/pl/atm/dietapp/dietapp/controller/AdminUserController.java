package pl.atm.dietapp.dietapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.atm.dietapp.dietapp.dto.UserDto;
import pl.atm.dietapp.dietapp.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminUserController {

    private UserService userService;

    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers(@RequestParam(required = false) Long deleteId, Model model){

        if (deleteId != null) {
            userService.delete(deleteId);
            return "redirect:users";
        }

        List<UserDto> tasks = userService.findAll();
        model.addAttribute("users", tasks);
        model.addAttribute("user", new UserDto());
        return "users";
    }
}
