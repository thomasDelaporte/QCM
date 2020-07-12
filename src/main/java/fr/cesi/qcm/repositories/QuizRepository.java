package fr.cesi.qcm.repositories;

import fr.cesi.qcm.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> { }
