package fr.cesi.qcm.controllers;

import fr.cesi.qcm.dto.QuizResult;
import fr.cesi.qcm.models.Quiz;
import fr.cesi.qcm.models.Score;
import fr.cesi.qcm.services.AnswerService;
import fr.cesi.qcm.services.QuizService;
import fr.cesi.qcm.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalTime;
import java.util.*;

@Controller
@RequestMapping("score")
public class ScoreController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private AnswerService answerService;

    /**
     * Retrieves the data from the quiz form and calculates the user's score and enters it into the database.
     *
     * @param model Model
     * @param quizResult DTO Object to retrieve the data from the form
     * @param request ServletRequest to retrieve the session
     * @return Template "score/index"
     */
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
        model.addAttribute("id_quiz", quiz.get().getId());

        model.addAttribute("score", score);

        return "score/index";
    }

    /**
     * Displays the ranking for a specific quiz.
     *
     * @param model Model
     * @param id_quiz GET Data id_quiz
     * @return Template "score/quiz"
     */
    @GetMapping("/quiz/{id_quiz}")
    public String getQuizScore(Model model, @PathVariable final long id_quiz){

        List<Score> scoresList = scoreService.getRanksByQuiz(id_quiz);
        model.addAttribute("scores", scoresList);

        return "score/quiz";
    }
}
