package com.example;

/*
* Name: John Campbell
* Section: COSC/ITSE 
* Homework: exercise 13
* Description: This creates and renders a progress bar for my Hi-Lo Game.
*/


public class ProgressBar {
    private String strProgressBar = ""; // for rendering the bar
    private int intCurrentProgress; // checking the players progress so far


    public ProgressBar() {

    }

    // obviously it resets the progress bar
    public void ResetBar(){
        intCurrentProgress = 0;
    }

    // this function renders the bar depending on the amount of guesses the player has.
    public String RenderBar() {
        if (intCurrentProgress == 10){
            intCurrentProgress = 0;
        } else intCurrentProgress++;

        while (intCurrentProgress < 11) {
            if (intCurrentProgress == 0) {
                strProgressBar = "[XXXXXXXXXX]";
                return strProgressBar;
            } else if (intCurrentProgress == 1) {
                strProgressBar = "9 [XXXXXXXX ]";
                return strProgressBar;
            } else if (intCurrentProgress == 2) {
                strProgressBar = "8 [XXXXXXX  ]";
                return strProgressBar;
            } else if (intCurrentProgress == 3) {
                strProgressBar = "7 [XXXXXX   ]";
                return strProgressBar;
            } else if (intCurrentProgress == 4) {
                strProgressBar = "6 [XXXXX    ]";
                return strProgressBar;
            }else if (intCurrentProgress == 5) {
                strProgressBar = "5 [XXXX     ]";
                return strProgressBar;
            } else if (intCurrentProgress == 6) {
                strProgressBar = "4 [XXXX     ]";
                return strProgressBar;
            } else if (intCurrentProgress == 7) {
                strProgressBar = "3 [XXX      ]";
                return strProgressBar;
            } else if (intCurrentProgress == 8) {
                strProgressBar = "2 [XX       ]";
                return strProgressBar;
            } else if (intCurrentProgress == 9) {
                strProgressBar = "1 [X        ]";
                return strProgressBar;
            } else if (intCurrentProgress == 10) {
                strProgressBar = "0 [         ]";
                return strProgressBar;
            }
        }
        return strProgressBar;
    }
}