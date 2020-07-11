
package fr.cesi.qcm.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_quiz;

    private String theme_quiz;


    public Long getId() {
        return id_quiz;
    }

    public void setId(Long id_quiz) {
        this.id_quiz = id_quiz;
    }

    public String getTheme_quiz() { return theme_quiz; }

    public void setTheme_quiz(String theme_quiz) { this.theme_quiz = theme_quiz; }
}
