package fr.cesi.qcm.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_answer;

    private String text_answer;

    private Boolean validity_answer;

    private Long id_question;

    public Long getId_answer() { return id_answer; }

    public void setId_answer(Long id_answer) { this.id_answer = id_answer; }

    public String getText_answer() { return text_answer; }

    public void setText_answer(String text_answer) { this.text_answer = text_answer; }

    public Boolean getValidity_answer() { return validity_answer; }

    public void setValidity_answer(Boolean validity_answer) { this.validity_answer = validity_answer; }

    public Long getId_question() { return id_question; }

    public void setId_question(Long id_question) { this.id_question = id_question; }

}