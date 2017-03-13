package com.example;

/*
* Name: John Campbell
* Section: COSC/ITSE 
* Homework: exercise 13
* Description: This creates and renders a progress bar for my Hi-Lo Game.
*/


public class ProgressBar {
    private String strProgressBar = "[     ]";
    private int intCurrentProgress;


    public ProgressBar() {

    }

    public void ResetBar(){
        intCurrentProgress = 0;
    }

    public String RenderBar() {

        if (intCurrentProgress == 5){
            intCurrentProgress = 0;
        } else intCurrentProgress++;

        while (intCurrentProgress < 6) {

            if (intCurrentProgress == 0) {
                strProgressBar = "[XXXXX]";
                return strProgressBar;
            } else if (intCurrentProgress == 1) {
                strProgressBar = "[XXXX ]";
                return strProgressBar;
            } else if (intCurrentProgress == 2) {
                strProgressBar = "[XXX  ]";
                return strProgressBar;
            } else if (intCurrentProgress == 3) {
                strProgressBar = "[XX   ]";
                return strProgressBar;
            } else if (intCurrentProgress == 4) {
                strProgressBar = "[X    ]";
                return strProgressBar;
            } else if (intCurrentProgress == 5) {
                strProgressBar = "[     ]";
                System.out.println("You have guessed quite a few times...");
                return strProgressBar;
            }
        }
        return strProgressBar;
    }
}