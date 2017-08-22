package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamBulls = 0;
    int scoreTeamBoston = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void addThreeForBulls(View v) {
        scoreTeamBulls = scoreTeamBulls + 3;
        displayForBulls(scoreTeamBulls);
    }

    public void addTwoForBulls(View v) {
        scoreTeamBulls = scoreTeamBulls + 2;
        displayForBulls(scoreTeamBulls);
    }

    public void freeThrowBulls(View v) {
        scoreTeamBulls = scoreTeamBulls + 1;
        displayForBulls(scoreTeamBulls);
    }

    public void addThreeForBoston(View v) {
        scoreTeamBoston = scoreTeamBoston + 3;
        displayForBoston(scoreTeamBoston);
    }

    public void addTwoForBoston(View v) {
        scoreTeamBoston = scoreTeamBoston + 2;
        displayForBoston(scoreTeamBoston);
    }

    public void freeThrowBoston(View v) {
        scoreTeamBoston = scoreTeamBoston + 1;
        displayForBoston(scoreTeamBoston);
    }

    public void resetScore(View v) {
        scoreTeamBoston = 0;
        scoreTeamBulls = 0;
        displayForBulls(scoreTeamBulls);
        displayForBoston(scoreTeamBoston);
    }


    /**
     * Displays the given score for Boston Celtics.
     */
    public void displayForBoston(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score1);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Chicago Bulls.
     */
    public void displayForBulls(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score2);
        scoreView.setText(String.valueOf(score));
    }
}

