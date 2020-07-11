package fr.cesi.qcm.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_question;

    private String text_question;

    private Long id_quiz;

    public Long getId_question() { return id_question; }

    public void setId_question(Long id_question) { this.id_question = id_question; }

    public String getText_question() { return text_question; }

    public void setText_question(String text_question) { this.text_question = text_question; }

    public Long getId_quiz() { return id_quiz; }

    public void setId_quiz(Long id_quiz) { this.id_quiz = id_quiz; }
}