package fr.cesi.qcm.repositories;

import fr.cesi.qcm.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> { }
