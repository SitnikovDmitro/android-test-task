package com.testtask.example1432;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    private QuizItem quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Quiz.getInstance().reset();
        reset();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_game_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void backArrowClicked(MenuItem item) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void nextButtonClick(View view) {
        reset();
    }

    public void firstAnswerButtonClick(View view) {
        Button button = findViewById(R.id.firstAnswerButton);
        button.setBackgroundColor(Color.parseColor("#F44336"));
        paintCorrectGreen(quiz.getCorrectAnswerIndex());
    }

    public void secondAnswerButtonClick(View view) {
        Button button = findViewById(R.id.secondAnswerButton);
        button.setBackgroundColor(Color.parseColor("#F44336"));
        paintCorrectGreen(quiz.getCorrectAnswerIndex());
    }

    public void thirdAnswerButtonClick(View view) {
        Button button = findViewById(R.id.thirdAnswerButton);
        button.setBackgroundColor(Color.parseColor("#F44336"));
        paintCorrectGreen(quiz.getCorrectAnswerIndex());
    }

    public void fourthAnswerButtonClick(View view) {
        Button button = findViewById(R.id.fourthAnswerButton);
        button.setBackgroundColor(Color.parseColor("#F44336"));
        paintCorrectGreen(quiz.getCorrectAnswerIndex());
    }

    private void paintCorrectGreen(int correctAnswerIndex) {
        int green = Color.parseColor("#4CAF50");
        if (correctAnswerIndex == 0) {
            Button button = findViewById(R.id.firstAnswerButton);
            button.setBackgroundColor(green);
        } else if (correctAnswerIndex == 1) {
            Button button = findViewById(R.id.secondAnswerButton);
            button.setBackgroundColor(green);
        } else if (correctAnswerIndex == 2) {
            Button button = findViewById(R.id.thirdAnswerButton);
            button.setBackgroundColor(green);
        } else {
            Button button = findViewById(R.id.fourthAnswerButton);
            button.setBackgroundColor(green);
        }
    }

    public void reset() {
        quiz = Quiz.getInstance().getQuizItem();

        TextView questionTextView = findViewById(R.id.questionTextView);
        Button firstAnswerButton = findViewById(R.id.firstAnswerButton);
        Button secondAnswerButton = findViewById(R.id.secondAnswerButton);
        Button thirdAnswerButton = findViewById(R.id.thirdAnswerButton);
        Button fourthAnswerButton = findViewById(R.id.fourthAnswerButton);

        questionTextView.setText(quiz.getQuestion());
        firstAnswerButton.setText(quiz.getAnswers()[0]);
        secondAnswerButton.setText(quiz.getAnswers()[1]);
        thirdAnswerButton.setText(quiz.getAnswers()[2]);
        fourthAnswerButton.setText(quiz.getAnswers()[3]);

        firstAnswerButton.setBackgroundColor(Color.parseColor("#3F51B5"));
        secondAnswerButton.setBackgroundColor(Color.parseColor("#3F51B5"));
        thirdAnswerButton.setBackgroundColor(Color.parseColor("#3F51B5"));
        fourthAnswerButton.setBackgroundColor(Color.parseColor("#3F51B5"));
    }
}