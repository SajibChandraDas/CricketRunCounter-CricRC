package com.example.sajibchandradas.crc2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Sajib Chandra Das on 5/30/2015.
 */
public class Registration extends ActionBarActivity {
    EditText etFirstName,etSecondName,etNumberOfPlayers;
    String fIN,sIN,nOP;
    int numberOfPlayers;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teams_name_layout);
        etFirstName=(EditText)findViewById(R.id.etFirstInnName);
        etSecondName=(EditText)findViewById(R.id.etSecondInnName);
        etNumberOfPlayers=(EditText)findViewById(R.id.etPlayerNumbers);


    }

    public void bNext(View view) {

        fIN=etFirstName.getText().toString();
        sIN=etSecondName.getText().toString();
        nOP=etNumberOfPlayers.getText().toString();

        Bundle firstNsecondInnNplayersBundle=new Bundle();
        firstNsecondInnNplayersBundle.putString("FirstInningsName",fIN);
        firstNsecondInnNplayersBundle.putString("SecondInningsName",sIN);
        firstNsecondInnNplayersBundle.putString("NumberOfPl",nOP);

        Intent goToMainActivity=new Intent(Registration.this,MainActivity.class);

        goToMainActivity.putExtras(firstNsecondInnNplayersBundle);

        startActivity(goToMainActivity);
        //startActivity(goToSecondActivity);

    }
}
