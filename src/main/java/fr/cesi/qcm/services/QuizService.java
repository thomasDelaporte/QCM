package fr.cesi.qcm.services;

import fr.cesi.qcm.models.Answer;
import fr.cesi.qcm.models.Quiz;
import fr.cesi.qcm.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public Quiz saveQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    public Optional<Quiz> getQuiz(final long id_quiz) {
        return this.quizRepository.findById(id_quiz);
    }

    public List<Quiz> getAllQuiz() {
        return this.quizRepository.findAll();
    }
}
