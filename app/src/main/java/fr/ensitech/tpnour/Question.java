package fr.ensitech.tpnour;

import java.util.List;

public class Question {
    private String question;
    private List<String> reponsesList;
    private int correctReponseIndex;

    public Question(String question, List<String> reponsesList, int correctReponseIndex) {
        this.question = question;
        this.reponsesList = reponsesList;
        this.correctReponseIndex = correctReponseIndex;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getReponsesList() {
        return reponsesList;
    }

    public void setReponsesList(List<String> reponsesList) {
        this.reponsesList = reponsesList;
    }

    public int getCorrectReponseIndex() {
        return correctReponseIndex;
    }
}
