package fr.cesi.qcm.models;

import javax.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_answer;

    private String label;

    private Boolean validity_answer;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_question")
    private Question question;

    public Answer() {}

    public Long getId_answer() {
        return id_answer;
    }

    public void setId_answer(Long id_answer) {
        this.id_answer = id_answer;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label ) {
        this.label = label ;
    }

    public Boolean getValidity_answer() {
        return validity_answer;
    }

    public void setValidity_answer(Boolean validity_answer) {
        this.validity_answer = validity_answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}