package pl.dietician.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping ("/home")
    public String loadHome(){
        return "home";
    }

    @RequestMapping ("/")
    public String loadIndex(){
        return "index";
    }
}
