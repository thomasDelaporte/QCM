package fr.cesi.qcm.dto;

import java.util.Map;

public class QuizResult {

    private String pseudo;
    private long id_quiz;
    private Map<String, Object> answers;

	public QuizResult(String pseudo, long id_quiz) {
		this.pseudo = pseudo;
		this.id_quiz = id_quiz;
	}

	@Override
	public String toString() {
		return "QuizResult{" +
				"pseudo='" + pseudo + '\'' +
				", id_quiz=" + id_quiz +
				'}';
	}

	public String getPseudo() {
		return this.pseudo;
	}

	public long getIdQuiz() {
		return this.id_quiz;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public void setId_quiz(long id_quiz) {
		this.id_quiz = id_quiz;
	}
}
