package com.example.sajibchandradas.crc2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by Sajib Chandra Das on 5/30/2015.
 */
public class SecondInningsWinner extends ActionBarActivity {
    TextView secondInningsWinnerTeam,wonByWickets;
    public int byWickets;
    String teamName;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.won_layout);
        secondInningsWinnerTeam=(TextView)findViewById(R.id.secondInningsWinnerName);
        wonByWickets=(TextView)findViewById(R.id.secondInningsWinnerByWickets);

        Bundle gotWickets=getIntent().getExtras();
        byWickets=gotWickets.getInt("WonByWickets");
        teamName=gotWickets.getString("STN");

        secondInningsWinnerTeam.setText(teamName);
        wonByWickets.setText(byWickets+" wickets");

    }
}
