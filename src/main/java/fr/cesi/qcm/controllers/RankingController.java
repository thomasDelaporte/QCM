package fr.cesi.qcm.controllers;

import fr.cesi.qcm.models.Quiz;
import fr.cesi.qcm.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;

import fr.cesi.qcm.models.Score;
import fr.cesi.qcm.repositories.QuestionRepository;
import fr.cesi.qcm.repositories.ScoreRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;





@Controller
public class RankingController {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private QuizRepository quizRepository;

    @GetMapping("/ranking")
   public String rankingInit(Model model){

        List<Score> scores = scoreRepository.findAll();
        return "ranking";
    }



    @GetMapping("/ranking/{id_quiz}")
    public String rankingP(Model model, @PathVariable Long id_quiz){
        ///Optional<Score> scores = scoreRepository.findById(id_quiz);

        Optional<Quiz> quizOptional = quizRepository.findById(id_quiz);
        //Optional<Quiz> quizOptional2 = quizRepository.findById((long) 3);
        Quiz quiz = quizOptional.get();
        model.addAttribute("questions", quiz.getQuestions());
        model.addAttribute("scores", quiz.getScores());
        return "ranking";
    }

}
