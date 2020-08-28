package fr.cesi.qcm.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_score;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_quiz", nullable = false)
    private Quiz quiz;

    private String pseudo;

    private int validAnswers;

    private long duration;

    private Date creationDate;

    public Long getId() {
        return this.id_score;
    }

    public void setId(Long id_score) {
        this.id_score = id_score;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getValidAnswers() {
        return this.validAnswers;
    }

    public void setValidAnswers(int validAnswers) {
        this.validAnswers = validAnswers;
    }

    public Long getDuration() {
        return this.duration;
    }

    public void setDuration(long quizDuration) {
        this.duration = quizDuration;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}