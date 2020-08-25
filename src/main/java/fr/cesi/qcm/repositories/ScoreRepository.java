package fr.cesi.qcm.repositories;

import fr.cesi.qcm.models.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> { }
