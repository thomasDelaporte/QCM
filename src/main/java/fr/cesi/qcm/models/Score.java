package fr.cesi.qcm.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_score;

    private String pseudo;

    private Long final_score;

    private Long time;

    private Date date;

    private Long id_quiz;

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

    public Long getId_quiz() {
        return id_quiz;
    }

    public void setId_quiz(Long id_quiz) {
        this.id_quiz = id_quiz;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id_score=" + id_score +
                ", pseudo='" + pseudo + '\'' +
                ", final_score=" + final_score +
                ", time=" + time +
                ", date=" + date +
                ", id_quiz=" + id_quiz +
                '}';
    }
}