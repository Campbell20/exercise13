package com.example;

/*
* Name: John Campbell
* Section: COSC/ITSE 
* Homework:
* Description: 
*/
public class ProgressBar {
    private String strProgressBar = "[     ]";
    private int intGuess;


    public ProgressBar() {
        System.out.println(RenderBar());
        intGuess = 0;
    }

    public int AmountofGuesses(){
        return intGuess;
    }

    public String RenderBar() {

        if (intGuess == 5){
            intGuess = 0;
        } else intGuess++;

        System.out.println(intGuess);

        while (intGuess < 6) {

            if (intGuess == 0) {
                strProgressBar = "[     ]";
                return strProgressBar;
            } else if (intGuess == 1) {
                strProgressBar = "[X    ]";
                return strProgressBar;
            } else if (intGuess == 2) {
                strProgressBar = "[XX   ]";
                return strProgressBar;
            } else if (intGuess == 3) {
                strProgressBar = "[XXX  ]";
                return strProgressBar;
            } else if (intGuess == 4) {
                strProgressBar = "[XXXX ]";
                return strProgressBar;
            } else if (intGuess == 5) {
                strProgressBar = "[XXXXX]";
                return strProgressBar;
            }
        }
        return strProgressBar;
    }
}