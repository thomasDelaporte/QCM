package fr.cesi.qcm.controllers;

import fr.cesi.qcm.dto.QuizResult;
import fr.cesi.qcm.models.Score;
import fr.cesi.qcm.repositories.QuestionRepository;
import fr.cesi.qcm.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.sql.Date;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("score")
public class ScoreController {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public String getScoreForQuiz(@PathVariable final long id_quiz) {
        return "score";
    }

    @PostMapping
    public String registerScore(@ModelAttribute QuizResult quizResult, ServletRequest request) {

        System.out.println(quizResult);
        /*
        Score score = new Score();

        score.setId_quiz(id_quiz);
        score.setDate(new Date(System.currentTimeMillis()));

        score.setPseudo(pseudo);
        score.setTime(null);
        score.setFinal_score((long) 0);

        scoreRepository.save(score);*/

        return "score";
    }
}
