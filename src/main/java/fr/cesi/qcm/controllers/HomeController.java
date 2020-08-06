package fr.cesi.qcm.controllers;

import fr.cesi.qcm.models.Answer;
import fr.cesi.qcm.models.Question;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    ScoreRepository scoreRepository;

    @GetMapping("/")
    public String home(Model model) {

        List<Quiz> quizzes = quizRepository.findAll();
        model.addAttribute("quizzes", quizzes);

        return "index";
    }

    @RequestMapping(value= "qcm", method = RequestMethod.POST)
    public String test(Model model,@RequestParam("pseudo") String pseudo,@RequestParam("qcm") long qcm) {

        /*TODO List<Question> questions = questionRepository where id_quiz = qcm */
        /// List<Question> questions = questionRepository.findAll();
        List<Question> questions = questionRepository.findAll();
        List<Question> questions2 = new ArrayList<Question>();

        //questions.forEach(System.out.println (" ff" ));
        //questions.removeIf(qcm != questions.id_quiz;
        for(Question question : questions){
            System.out.println(question.getId_quiz());
            System.out.println(qcm);
            if (question.getId_quiz() == qcm) {
                System.out.println("true");
                System.out.println(this.questionRepository.getOne(question.getId_quiz()));
                System.out.println(this.questionRepository.getOne(question.getId_question()));
                //questions2.add(this.questionRepository.getOne(question.getId_quiz()));
                questions2.add(question);
            }
            System.out.println(question);

        };


        List<Answer> answers = answerRepository.findAll();

        model.addAttribute("questions",questions2);
        model.addAttribute("numberQuestions",questions2.size());
        model.addAttribute("pseudo", pseudo);
        model.addAttribute("idThemeQuiz", qcm); //
        return "qcm";
    }


    /* debug purpose */
    @GetMapping("/qcm2")
    public String qcm2(Model model) {

        List<Question> questions = questionRepository.findAll();
        model.addAttribute("questions",questions);
        return "qcm";
    }

    @GetMapping("/score2")
    public String score2(Model model) {

        List<Question> questions = questionRepository.findAll();
        model.addAttribute("questions",questions);
        return "score";
    }


}
