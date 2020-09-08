package fr.cesi.qcm.services;

import fr.cesi.qcm.models.Quiz;
import fr.cesi.qcm.models.Score;
import fr.cesi.qcm.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public Score createScore(Score score) {
        return scoreRepository.save(score);
    }

    public List<Score> getRanksByQuiz(long id_quiz) {
        return scoreRepository.findScoresByQuizAndRank(id_quiz);
    }
}
