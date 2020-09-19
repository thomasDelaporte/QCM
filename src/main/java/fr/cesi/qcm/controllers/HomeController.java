package fr.cesi.qcm.controllers;

import fr.cesi.qcm.models.Quiz;
import fr.cesi.qcm.repositories.QuizRepository;
import fr.cesi.qcm.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    QuizService quizService;

    /**
     * Display home page with all the quiz available in the database.
     *
     * @param model
     * @return template "index"
     */
    @GetMapping
    public String home(Model model) {

        List<Quiz> quizzes = quizService.getAllQuiz();
        model.addAttribute("quizzes", quizzes);

        return "index";
    }
}
