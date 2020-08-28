package fr.cesi.qcm.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_quiz;

    private String theme;

    @OneToMany(mappedBy = "quiz")
    private List<Question> questions;

    @OneToMany(mappedBy = "quiz")
    private List<Score> scores;

    public Long getId() {
        return id_quiz;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<Question> getQuestions() {
        return this.questions;
    }

    public List<Score> getScores() {
        return this.scores;
    }

    public void setScore(List<Score> score) {
        this.scores = score;
    }
}
