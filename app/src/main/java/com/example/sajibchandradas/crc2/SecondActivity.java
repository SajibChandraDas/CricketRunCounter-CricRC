package com.example.sajibchandradas.crc2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Sajib Chandra Das on 5/30/2015.
 */
public class SecondActivity extends ActionBarActivity {
    TextView tvDisplayForSecondInnings ,tvTarget,tvNeed;
    public int runThisBallAtSecondInnings=0;
    public int wicketThisBallAtSecondInnings=0;
    public int firstInnings;
    public int target;
    public int wonBW;
    public int wonBR;

    String secondTeamName,numberOfPlayers;
    int wicketPlayersSecondInn;
    String firstTeamName;


    InfoActivity infoActivity2=new InfoActivity();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        //FromBundle();

        tvDisplayForSecondInnings=(TextView)findViewById(R.id.tvDisplayForSecondInnings);
        tvTarget=(TextView)findViewById(R.id.tvTarget);
        tvNeed=(TextView)findViewById(R.id.tvNeedScore);

        Bundle gotFirstInningsBundle=getIntent().getExtras();
        firstInnings=gotFirstInningsBundle.getInt("FirstInningsRun");
        wicketPlayersSecondInn=gotFirstInningsBundle.getInt("WicketsOfSecondInn");
        firstTeamName=gotFirstInningsBundle.getString("FrstTmNme");
        secondTeamName=gotFirstInningsBundle.getString("ScndTmNm");

        target=firstInnings+1;
        tvTarget.setText("Target: "+target);
    }

//    private void FromBundle() {
//
//        Bundle gotSecondTeamNnumberOfPlayers=getIntent().getExtras();
//        secondTeamName=gotSecondTeamNnumberOfPlayers.getString("SecondInningsName");
//    }

    public void SecondInningsSix(View view) {
        runThisBallAtSecondInnings=6;
        calculateRunsOfSecondInnings();
        Toast.makeText(this,"Six",Toast.LENGTH_LONG).show();
    }
    public void SecondInningsFour(View view) {
        runThisBallAtSecondInnings=4;
        calculateRunsOfSecondInnings();
        Toast.makeText(this,"Six",Toast.LENGTH_SHORT).show();
    }
    public void SecondInningsThree(View view) {
        runThisBallAtSecondInnings=3;
        calculateRunsOfSecondInnings();
    }
    public void SecondInningsTwo(View view) {
        runThisBallAtSecondInnings=2;
        calculateRunsOfSecondInnings();
    }
    public void SecondInningsOne(View view) {
        runThisBallAtSecondInnings=1;
        calculateRunsOfSecondInnings();
    }
    public void SecondInningsWide(View view) {
        runThisBallAtSecondInnings=1;
        calculateRunsOfSecondInnings();
    }
    public void SecondInningsNoBall(View view) {
        runThisBallAtSecondInnings=1;
        calculateRunsOfSecondInnings();
        Toast.makeText(this,"Six",Toast.LENGTH_SHORT).show();
    }
    public void SecondInningsWickets(View view) {
        wicketThisBallAtSecondInnings=1;
        calculateWicketsOfSecondInnings();
        Toast.makeText(this,"Six",Toast.LENGTH_LONG).show();
    }

    private void calculateRunsOfSecondInnings() {
        if (infoActivity2.wicketsOfSecondInnings<wicketPlayersSecondInn){
            infoActivity2.ROSI(runThisBallAtSecondInnings);
            tvDisplayForSecondInnings.setText(secondTeamName+": "+infoActivity2.runOfSecondInnings+"/"+infoActivity2.wicketsOfSecondInnings);
            infoActivity2.need(target);
            tvNeed.setText("Need "+infoActivity2.needScore+" runs to win");
            if (infoActivity2.needScore==1){
                tvNeed.setText("Scores Level");
            }else if (infoActivity2.needScore<=0){
                tvNeed.setText("Won the match");
                wonBW=wicketPlayersSecondInn-infoActivity2.wicketsOfSecondInnings;
                Bundle wonBWBundle=new Bundle();
                wonBWBundle.putInt("WonByWickets",wonBW);
                wonBWBundle.putString("STN",secondTeamName);
                Intent goWonByWicket=new Intent(SecondActivity.this,SecondInningsWinner.class);
                goWonByWicket.putExtras(wonBWBundle);
                startActivity(goWonByWicket);
            }
        }else if (infoActivity2.wicketsOfSecondInnings>=wicketPlayersSecondInn){
            infoActivity2.ROSI(0);
            tvDisplayForSecondInnings.setText(secondTeamName+": "+infoActivity2.runOfSecondInnings);
        }

    }
    private void calculateWicketsOfSecondInnings() {
        if (infoActivity2.wicketsOfSecondInnings<wicketPlayersSecondInn){
            infoActivity2.WOSI(wicketThisBallAtSecondInnings);
            tvDisplayForSecondInnings.setText(secondTeamName+": "+infoActivity2.runOfSecondInnings+"/"+infoActivity2.wicketsOfSecondInnings);
        }else if (infoActivity2.wicketsOfSecondInnings>=wicketPlayersSecondInn){
            infoActivity2.WOSI(0);
            tvDisplayForSecondInnings.setText(secondTeamName+": "+infoActivity2.runOfSecondInnings);
        }

    }

    public void EndOfSecondInnings(View view) {
        wonBR=firstInnings-infoActivity2.runOfSecondInnings;
        Bundle wonByRunsBundle=new Bundle();
        wonByRunsBundle.putInt("WonByRuns",wonBR);
        wonByRunsBundle.putString("FTN",firstTeamName);
        Intent goFirstInningsWinner=new Intent(SecondActivity.this,FirstInningsWinner.class);
        goFirstInningsWinner.putExtras(wonByRunsBundle);
        startActivity(goFirstInningsWinner);
    }




}
