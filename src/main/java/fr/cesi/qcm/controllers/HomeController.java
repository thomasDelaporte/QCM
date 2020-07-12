package fr.cesi.qcm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index.html";
    }

    @RequestMapping(value= "qcm", method = RequestMethod.GET)
    public String test() {
        return "qcm.html";
    }
}
