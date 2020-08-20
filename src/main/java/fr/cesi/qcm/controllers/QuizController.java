package fr.cesi.qcm.controllers;

import fr.cesi.qcm.models.Quiz;
import fr.cesi.qcm.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizRepository quizRepository;

    @PostMapping
    public String getQuiz(Model model, @RequestParam("pseudo") String pseudo, @RequestParam("qcm") long id_quiz) {

        Optional<Quiz> quizOptional = quizRepository.findById(id_quiz);

        if(quizOptional.isEmpty())
            return "redirect:/";

        Quiz quiz = quizOptional.get();

        model.addAttribute("pseudo", pseudo);
        model.addAttribute("id_quiz", id_quiz);

        model.addAttribute("questions", quiz.getQuestions());

        return "quiz";
    }
}
