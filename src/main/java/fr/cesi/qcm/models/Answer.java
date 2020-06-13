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

    private Boolean result;

    private int total_valid;

    private float duration;

    public Long getId() {
        return id_answer;
    }

    public void setId(Long id_answer) {
        this.id_answer = id_answer;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public int getTotalValid() {
        return total_valid;
    }

    public void setTotalValid(int total_valid) {
        this.total_valid = total_valid;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }
}
