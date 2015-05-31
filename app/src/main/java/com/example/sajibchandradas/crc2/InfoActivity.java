package com.example.sajibchandradas.crc2;

import android.support.v7.app.ActionBarActivity;

/**
 * Created by Sajib Chandra Das on 5/29/2015.
 */
public class InfoActivity extends ActionBarActivity {

    public int runOfFirstInnings=0;
    public int runOfSecondInnings=0;
    public int wicketsOfFirstInnings=0;
    public int wicketsOfSecondInnings=0;
    public int targetScore=0;
    public int needScore=0;

    public void ROFI(int runsOfFI){
        runOfFirstInnings +=runsOfFI;
    }
    public void WOFI(int wicketsOfFI){
        wicketsOfFirstInnings +=wicketsOfFI;
    }



    public void ROSI(int runsOfSI){
        runOfSecondInnings +=runsOfSI;
    }
    public void WOSI(int wicketsOfSI){
        wicketsOfSecondInnings +=wicketsOfSI;
    }


    public void target(int firstInnings){
        targetScore=firstInnings+1;
    }
    public void need(int target){
        needScore=target- runOfSecondInnings;
    }




}
