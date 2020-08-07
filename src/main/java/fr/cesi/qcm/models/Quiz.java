package fr.cesi.qcm.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_quiz;

    private String theme;

    @OneToMany(mappedBy = "quiz")
    private Collection<Question> questions;

    public Long getId() {
        return id_quiz;
    }

    public void setId(Long id_quiz) {
        this.id_quiz = id_quiz;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Collection<Question> getQuestions() {
        return questions;
    }

    public void setQuestion(Collection<Question> question) {
        this.questions = question;
    }
}
