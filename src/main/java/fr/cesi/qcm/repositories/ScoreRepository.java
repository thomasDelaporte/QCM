package fr.cesi.qcm.repositories;

import fr.cesi.qcm.models.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {

    @Query(value = "SELECT * FROM score WHERE id_quiz = ?1 ORDER BY valid_answers DESC, duration DESC", nativeQuery = true)
    List<Score> findScoresByQuizAndRank(long id_quiz);
}
