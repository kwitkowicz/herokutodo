package pl.krzysiekwitkowicz.herokutodo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class MainController {
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("title","Welcome");
        model.addAttribute("message", "This is welcome page");
        return "indexPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {

        return "loginPage";
    }
    @RequestMapping(value="/todoList", method = RequestMethod.GET)
    public String todoPage(Model model) {
        return "todoList";
    }

    @RequestMapping(value = "logoutSuccessful", method = RequestMethod.GET)
        public String logoutSuccessfulPage(Model model){
            model.addAttribute("title","Logout");
            return "logoutSuccessfulPage";
        }

}
