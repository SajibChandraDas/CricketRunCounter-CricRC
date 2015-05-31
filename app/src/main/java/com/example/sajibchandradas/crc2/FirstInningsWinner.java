package com.example.sajibchandradas.crc2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by Sajib Chandra Das on 5/30/2015.
 */
public class FirstInningsWinner extends ActionBarActivity {
    TextView firstInnWin,byRuns;
    public int wonByRuns;
    String firstTN;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_inn_winner_layout);

        firstInnWin=(TextView)findViewById(R.id.firstInningsWinnerName);
        byRuns=(TextView)findViewById(R.id.firstInningsWinnerByRuns);

        Bundle gotRuns=getIntent().getExtras();
        wonByRuns=gotRuns.getInt("WonByRuns");
        firstTN=gotRuns.getString("FTN");

        firstInnWin.setText(firstTN);
        byRuns.setText(wonByRuns+" runs");

    }
}
