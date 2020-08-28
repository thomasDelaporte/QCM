package fr.cesi.qcm.controllers;

import fr.cesi.qcm.dto.QuizResult;
import fr.cesi.qcm.models.Answer;
import fr.cesi.qcm.models.Question;
import fr.cesi.qcm.models.Quiz;
import fr.cesi.qcm.models.Score;
import fr.cesi.qcm.repositories.AnswerRepository;
import fr.cesi.qcm.repositories.QuizRepository;
import fr.cesi.qcm.repositories.ScoreRepository;
import fr.cesi.qcm.services.AnswerService;
import fr.cesi.qcm.services.QuizService;
import fr.cesi.qcm.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.DateUtils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("score")
public class ScoreController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private AnswerService answerService;

    @PostMapping
    public String registerScore(Model model, @ModelAttribute QuizResult quizResult, HttpServletRequest request) {

        Optional<Quiz> quiz = quizService.getQuiz(quizResult.getIdQuiz());

        /**
         * Check if the quiz exists.
         */
        if(quiz.isEmpty())
            return "error";

        Map<Long, Long> quizResultAnswers = quizResult.getAnswers();

        /**
         * Calculate the time taken by the user by comparing the start
         * value and the end value.
         */
        HttpSession httpSession = request.getSession(false);

        if(httpSession == null)
            return "error";

        long quizStart = (long) httpSession.getAttribute("quiz_start");
        long quizEnd = (long) System.currentTimeMillis();
        long quizDuration = (quizEnd - quizStart) / 1000;

        httpSession.removeAttribute("quiz_start");

        /**
         * Retrieve the number of correct answers.
         */
        long validAnswers = quizResultAnswers.values().stream().
                filter((e) -> answerService.getAnswer(e).get().getValidity() ).count();


        Score score = new Score();

        score.setQuiz(quiz.get());
        score.setPseudo(quizResult.getPseudo());
        score.setValidAnswers((int) validAnswers);
        score.setDuration(quizDuration);
        score.setCreationDate(new Date());

        score = scoreService.createScore(score);

        model.addAttribute("quiz_duration", LocalTime.MIN.plusSeconds(quizDuration).toString());
        model.addAttribute("total_questions", quizResultAnswers.size());

        model.addAttribute("score", score);

        return "score";
    }
}
