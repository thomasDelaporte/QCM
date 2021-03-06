package fr.cesi.qcm.repositories;

import fr.cesi.qcm.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> { }
