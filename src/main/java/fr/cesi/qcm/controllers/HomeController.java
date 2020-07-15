package fr.cesi.qcm.controllers;

import fr.cesi.qcm.models.Quiz;
import fr.cesi.qcm.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    QuizRepository quizRepository;

    @GetMapping("/")
    public String home(Model model) {

        List<Quiz> quizzes = quizRepository.findAll();
        model.addAttribute("quizzes", quizzes);

        return "index";
    }

    @RequestMapping(value= "qcm", method = RequestMethod.GET)
    public String test() {
        return "qcm";
    }
}
