package com.example.sajibchandradas.crc2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    TextView tvDisplayForFirstInnings;
    public int runThisBallAtFirstInnings=0;
    public int wicketThisBallAtFirstInnings=0;
    InfoActivity infoActivity=new InfoActivity();

    String firstTeamName,secondTeamName,numberOfPlayers;
    int numOfPlay,totalWickets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDisplayForFirstInnings=(TextView)findViewById(R.id.tvDisplayForFirstInnings);

        Bundle gotFirstTeamNameNumberOfPlayers=getIntent().getExtras();
        firstTeamName=gotFirstTeamNameNumberOfPlayers.getString("FirstInningsName");
        secondTeamName=gotFirstTeamNameNumberOfPlayers.getString("SecondInningsName");
        numberOfPlayers=gotFirstTeamNameNumberOfPlayers.getString("NumberOfPl");
        numOfPlay=Integer.parseInt(numberOfPlayers);
        totalWickets=numOfPlay-1;

    }

    public void FirstInningsSix(View view) {
        runThisBallAtFirstInnings=6;
        calculateRunsOfFirstInnings();
        Toast.makeText(this,"Six",Toast.LENGTH_LONG).show();
    }

    public void FirstInningsFour(View view) {
        runThisBallAtFirstInnings=4;
        calculateRunsOfFirstInnings();
        Toast.makeText(this,"Four",Toast.LENGTH_SHORT).show();
    }

    public void FirstInningsThree(View view) {
        runThisBallAtFirstInnings=3;
        calculateRunsOfFirstInnings();
    }

    public void FirstInningsTwo(View view) {
        runThisBallAtFirstInnings=2;
        calculateRunsOfFirstInnings();
    }

    public void FirstInningsOne(View view) {
        runThisBallAtFirstInnings=1;
        calculateRunsOfFirstInnings();
    }

    public void FirstInningsWide(View view) {
        runThisBallAtFirstInnings=1;
        calculateRunsOfFirstInnings();
    }

    public void FirstInningsNoBall(View view) {
        runThisBallAtFirstInnings=1;
        calculateRunsOfFirstInnings();
        Toast.makeText(this,"No Ball",Toast.LENGTH_SHORT).show();
    }

    public void FirstInningsWickets(View view) {
        wicketThisBallAtFirstInnings=1;
        calculateWicketsOfFirstInnings();
        Toast.makeText(this,"Wicket",Toast.LENGTH_LONG).show();
    }

    public void EndOfFirstInnings(View view) {
        Bundle FirstInningsBundle=new Bundle();
        FirstInningsBundle.putInt("FirstInningsRun", infoActivity.runOfFirstInnings);
        FirstInningsBundle.putInt("WicketsOfSecondInn",totalWickets);
        FirstInningsBundle.putString("FrstTmNme",firstTeamName);
        FirstInningsBundle.putString("ScndTmNm",secondTeamName);
        Intent goSecondInnings=new Intent(MainActivity.this,SecondActivity.class);
        goSecondInnings.putExtras(FirstInningsBundle);
        startActivity(goSecondInnings);
    }


    private void calculateRunsOfFirstInnings() {
        if (infoActivity.wicketsOfFirstInnings<totalWickets){
            infoActivity.ROFI(runThisBallAtFirstInnings);
            tvDisplayForFirstInnings.setText(firstTeamName+": "+infoActivity.runOfFirstInnings+"/"+infoActivity.wicketsOfFirstInnings);
        }else if (infoActivity.wicketsOfFirstInnings>=totalWickets){
            infoActivity.ROFI(0);
            tvDisplayForFirstInnings.setText(firstTeamName+": "+infoActivity.runOfFirstInnings);
        }
    }

    private void calculateWicketsOfFirstInnings() {
        if (infoActivity.wicketsOfFirstInnings<totalWickets){
            infoActivity.WOFI(wicketThisBallAtFirstInnings);
            tvDisplayForFirstInnings.setText(firstTeamName+": "+infoActivity.runOfFirstInnings+"/"+infoActivity.wicketsOfFirstInnings);
        }else if (infoActivity.wicketsOfFirstInnings>=totalWickets){
            infoActivity.WOFI(0);
            tvDisplayForFirstInnings.setText(firstTeamName+": "+infoActivity.runOfFirstInnings);
        }
    }

}
