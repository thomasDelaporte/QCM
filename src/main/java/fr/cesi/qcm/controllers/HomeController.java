package fr.cesi.qcm.controllers;

import fr.cesi.qcm.models.Quiz;
import fr.cesi.qcm.repositories.AnswerRepository;
import fr.cesi.qcm.repositories.QuestionRepository;
import fr.cesi.qcm.repositories.QuizRepository;
import fr.cesi.qcm.repositories.ScoreRepository;
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
public class HomeController {

    @Autowired
    QuizRepository quizRepository;

    @GetMapping("/")
    public String home(Model model) {

        List<Quiz> quizzes = quizRepository.findAll();
        model.addAttribute("quizzes", quizzes);

        return "index";
    }

    @RequestMapping(value= "quiz", method = RequestMethod.POST)
    public String test(Model model, @RequestParam("pseudo") String pseudo, @RequestParam("qcm") long id_qcm) {

        Optional<Quiz> quizOptional = quizRepository.findById(id_qcm);

        if(quizOptional.isEmpty())
            return "redirect:/";

        Quiz quiz = quizOptional.get();
        model.addAttribute("questions", quiz.getQuestions());

        quiz.getQuestions().forEach((question -> System.out.println(question.getAnswers())));

        return "quiz";
    }
}
