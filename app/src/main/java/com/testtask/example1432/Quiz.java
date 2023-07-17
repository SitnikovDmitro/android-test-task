package com.testtask.example1432;

public class Quiz {
    private static Quiz instance;
    private final QuizItem[] quizItems;
    private int currentIndex;

    private Quiz() {
        quizItems = new QuizItem[4];
        quizItems[0] = new QuizItem("How many planets in the Solar system?", new String[]{"3", "8", "9", "12"}, 1);
        quizItems[1] = new QuizItem("What is the correct result of 2+2*2?", new String[]{"4", "8", "6", "666"}, 2);
        quizItems[2] = new QuizItem("What city is capital of USA?", new String[]{"Berlin", "New York", "Kiev", "Washington"}, 3);
        quizItems[3] = new QuizItem("What is the chemical formula of alcohol?", new String[]{"С2H5OH", "H2O", "CH4", "NaOH"}, 0);
        currentIndex = 0;
    }

    public QuizItem getQuizItem() {
        QuizItem result = quizItems[currentIndex];
        currentIndex = (currentIndex+1) % quizItems.length;
        return result;
    }

    public void reset() {
        currentIndex = 0;
    }

    public static Quiz getInstance() {
        if (instance == null) instance = new Quiz();
        return instance;
    }
}
