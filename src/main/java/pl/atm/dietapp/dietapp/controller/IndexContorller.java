package pl.atm.dietapp.dietapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"","/","/index","/index.html"})
public class IndexContorller {

    @RequestMapping
    public String index(){
        return "index";
    }
}
