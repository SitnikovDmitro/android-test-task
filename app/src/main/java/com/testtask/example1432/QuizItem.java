package com.testtask.example1432;

import java.security.InvalidParameterException;

public class QuizItem {
    private String question;
    private String[] answers;
    private int correctAnswerIndex;

    public QuizItem(String question, String[] answers, int correctAnswerIndex) {
        this.question = question;
        setAnswers(answers);
        setCorrectAnswerIndex(correctAnswerIndex);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        if (answers.length != 4) throw new InvalidParameterException();

        this.answers = answers;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public void setCorrectAnswerIndex(int correctAnswerIndex) {
        if (correctAnswerIndex < 0 || correctAnswerIndex >= 4) throw new InvalidParameterException();

        this.correctAnswerIndex = correctAnswerIndex;
    }
}
