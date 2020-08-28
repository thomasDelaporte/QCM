package fr.cesi.qcm.services;

import fr.cesi.qcm.models.Answer;
import fr.cesi.qcm.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    public Optional<Answer> getAnswer(final Long id_answer) {
        return this.answerRepository.findById(id_answer);
    }
}
