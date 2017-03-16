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
        intCurrentProgress = 11;
    }

    // this function renders the bar depending on the amount of guesses the player has.
    public String RenderBar() {
        if (intCurrentProgress == 11){
            intCurrentProgress = 10;
        } else intCurrentProgress--;

        while (intCurrentProgress < 12) {
            if (intCurrentProgress == 10) {
                strProgressBar = "10 [**********]";
                return strProgressBar;
            } else if (intCurrentProgress == 9) {
                strProgressBar = "9 [-*********]";
                return strProgressBar;
            } else if (intCurrentProgress == 8) {
                strProgressBar = "8 [--********]";
                return strProgressBar;
            } else if (intCurrentProgress == 7) {
                strProgressBar = "7 [---*******]";
                return strProgressBar;
            } else if (intCurrentProgress == 6) {
                strProgressBar = "6 [----******]";
                return strProgressBar;
            }else if (intCurrentProgress == 5) {
                strProgressBar = "5 [----X*****]";
                System.out.println("You only have five guesses left!! Use them wisely.");
                return strProgressBar;
            } else if (intCurrentProgress == 4) {
                strProgressBar = "4 [----X-****]";
                return strProgressBar;
            } else if (intCurrentProgress == 3) {
                strProgressBar = "3 [----X--***]";
                return strProgressBar;
            } else if (intCurrentProgress == 2) {
                strProgressBar = "2 [----X---**]";
                return strProgressBar;
            } else if (intCurrentProgress == 1) {
                strProgressBar = "1 [----X----*]";
                System.out.println("Only one guess left!");
                return strProgressBar;
            } else if (intCurrentProgress == 0) {
                strProgressBar = "0 [----X----X]";
                return strProgressBar;
            }
        }
        return strProgressBar;
    }
}