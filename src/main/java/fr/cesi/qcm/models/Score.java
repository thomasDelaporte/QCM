package fr.cesi.qcm.models;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalTime;
import java.util.Collection;

@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_score;

    private String pseudo;

    private Long final_score;

    private Long time;

    private Date date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_quiz", nullable = false)
    private Quiz quiz;

    public Score(){}

    public Score(String pseudo, Long final_score, Long time, Date date, Quiz quiz) {
    this.pseudo = pseudo;
    this.final_score = final_score;
    this.time = time;
    this.quiz = quiz;
    }



    public Long getId_score() {
        return id_score;
    }

    public void setId_score(Long id_score) {
        this.id_score = id_score;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Long getFinal_score() {
        return final_score;
    }

    public void setFinal_score(Long final_score) {
        this.final_score = final_score;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id_score=" + id_score +
                ", pseudo='" + pseudo + '\'' +
                ", final_score=" + final_score +
                ", time=" + time +
                ", date=" + date +
                ", id_quiz=" + quiz +
                '}';
    }
}