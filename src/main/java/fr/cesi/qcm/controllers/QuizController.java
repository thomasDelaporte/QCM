package fr.cesi.qcm.controllers;

import fr.cesi.qcm.dto.QuizResult;
import fr.cesi.qcm.models.Quiz;
import fr.cesi.qcm.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    /**
     * Retrieve the questions about a specific quiz and prepare an fake ModelAttribute object to
     * be able to retrieve the data properly at the end of the form.
     *
     * @param model Model
     * @param request RequestServlet to retrieve the session
     * @param pseudo Post data pseudo
     * @param id_quiz Post data id_quiz
     * @return Template "quiz/index"
     */
    @PostMapping
    public String getQuiz(Model model, HttpServletRequest request,
                          @RequestParam("pseudo") String pseudo, @RequestParam("quiz") long id_quiz) {

        Optional<Quiz> quizOptional = quizService.getQuiz(id_quiz);

        if(quizOptional.isEmpty())
            return "redirect:/";

        Quiz quiz = quizOptional.get();

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("quiz_start", System.currentTimeMillis());

        QuizResult quizResult = new QuizResult(pseudo, id_quiz);

        model.addAttribute("quiz", quiz);
        model.addAttribute("quizResult", quizResult);
        model.addAttribute("questions", quiz.getQuestions());

        return "quiz/index";
    }
}
