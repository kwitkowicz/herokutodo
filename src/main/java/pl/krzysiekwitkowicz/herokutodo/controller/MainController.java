package pl.krzysiekwitkowicz.herokutodo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.krzysiekwitkowicz.herokutodo.service.UserServiceImpl;

import java.security.Principal;

@Controller
public class MainController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model, Principal principal) {
        if (principal != null) {
            model.addAttribute("name", userService.findNameByLogin(principal.getName()));
        } else {
            model.addAttribute("name", "Stranger");
        }
        model.addAttribute("title", "Welcome");

        return "indexPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {

        return "loginPage";
    }

    @RequestMapping(value = "logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        return "logoutSuccessfulPage";
    }

}
