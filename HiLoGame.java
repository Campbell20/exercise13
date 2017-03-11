package com.example;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
* Name: John Campbell
* Section: COSC/ITSE 
* Homework:
* Description: 
*/

public class HiLoGame {
    private String strEndInput = "Y";
    private int intTotal = 201;
    private int intPercent = 0;
    private int intQuit = 0;
    private int intPlayerCurrentGuess;
    private int intCorrectNumber;
    private int intGuesses;
    private int intRandomNumber = 100;

    Scanner objInput = new Scanner(System.in);

    // constructor for the game
    public void HiLoGame() throws InterruptedException {
        //reads the game rules to the player
        GameRules();
        //starts the game for the player
        StartGame();
        // keeps running the game until the player quits
        RunGame();

    }

    private void GameRules() throws InterruptedException {
        System.out.println("\n" +
                "\t\t*******************************\n" +
                "\t\t*          Hi-Lo              *\n" +
                "\t\t*        The Video Game       *\n" +
                "\t\t*******************************\n\n");
        System.out.println("Rules: ");
        System.out.println("\tYou must guess the correct number from 1 to 100.");
        System.out.println("\tYou will be given 20 attempts to guess the right number.");
        //  TimeUnit.SECONDS.sleep(1);
    }

    // starts the game for the user by setting a random number that they need to guess
    private void StartGame() throws InterruptedException {
        System.out.println(""); // adding a bit of space between rules, and game start
        System.out.println(""); // adding space between rules and game start
        System.out.println("Setting the number to guess...");
        // sets the random number for us each round
        Random objRandomNumber = new Random();
        intCorrectNumber = objRandomNumber.nextInt(intRandomNumber) + 1;
        CorrectNumber(CorrectNumber());
        // TimeUnit.SECONDS.sleep(2);
        System.out.println("Number set. Can you guess it? Good luck!\n\n");
    }

    // runs the game
    private void RunGame() throws InterruptedException {
        while (intQuit == 0) {
            // asks the user to guess a number
            System.out.println("What number would you like to guess? ");
            CurrentGuess(CurrentGuess());
            // adds 1 more guess
            intGuesses++;
            // sets the guess amount in the progress bar
           // Percent(intGuesses);

            // checks the value of the player's guess vs the correct number and gives the player some hints
            // tells the player they're too low
            if (intPlayerCurrentGuess < intCorrectNumber) {
                System.out.println("You're to low! ");
                // checks to see if the player wants to quit
                CheckOnPlayer(CheckOnPlayer());
                // tells the player they're to high
            } else if (intPlayerCurrentGuess > intCorrectNumber) {
                System.out.println("You're to high! ");
                // checks to see if the player wants to quit
                CheckOnPlayer(CheckOnPlayer());
                // tells the player they have won!
            } else {
                PlayAgain(PlayAgain());
            }
        }
    }

    // checks to see if the player wants to play again after winning a round
    private void PlayAgain(int pPlayAgain) {
        // System.out.println(intQuit); //testing PlayAgain function
        intQuit = pPlayAgain;
    }

    private int PlayAgain() throws InterruptedException {
        System.out.println("The number was " + intCorrectNumber);
        System.out.println("You guessed correctly!");
        System.out.println("It only took you " + intGuesses + " guesses until you got the number correct.");
        System.out.println("Would you like to play again?");
        System.out.println("Type \"Y\" to play again, or \"N\" to quit the program.");
        strEndInput = objInput.next().toUpperCase();
        if (strEndInput.equals("Y")) {
            // sets the random number for us each round
            Random objRandomNumber = new Random();
            intCorrectNumber = objRandomNumber.nextInt(intRandomNumber) + 1;
            // resets current guesses
            intGuesses = 0;
            StartGame();
            return intQuit = 0;
        } else
            return intQuit = 1;
    }

    // checks to see if the player wants to quit or not during a round
    private void CheckOnPlayer(int pCheckOnPlayer) {
        //System.out.println(intQuit); //testing the CheckOnPlayer function
        intQuit = pCheckOnPlayer;
    }

    private int CheckOnPlayer() throws InterruptedException {
        if ((intGuesses == 5) || (intGuesses == 10) || (intGuesses == 15)) {
            System.out.println("You have guessed quite a few times... Would you like to quit?");
            System.out.println("Type \"Y\" to quit, or \"N\" to to keep playing.");
            strEndInput = objInput.next().toUpperCase();
            if (strEndInput.equals("N")) {
                return intQuit = 0;
            } else if (intGuesses == 20) {
                System.out.println("You guessed the wrong number " + intGuesses + "times. \n" +
                        "The correct number was " + intCorrectNumber);
                return intQuit = 1;
            } else
                return intQuit = 1;
        } else {
            return intQuit = 0;
        }
    }

    // gets the player's current guess
    private void CurrentGuess(int pPlayerCurrentGuess) {
        intPlayerCurrentGuess = pPlayerCurrentGuess;
    }

    private int CurrentGuess() {
        intPlayerCurrentGuess = objInput.nextInt();
        return intPlayerCurrentGuess;
    }

    /*

    GOTTA FIGURE OUT THE PROGRESS BAR BULLSHIT
    public int Percent() {
        return intPercent;
    }

    public void Percent(int pintPercent) {
        intPercent = pintPercent;
    }

    private int PercentOfTotal() {
        return (Percent() * intTotal) / 20;
    }

    public String ProgressBar() throws InterruptedException {
        String strProgressBar = "[";
        // checkpoint (3 total)
        if(PercentOfTotal() <= 4){
            int intCurrentProgress = 1;
            while (intCurrentProgress <= this.intTotal) {
                if (intCurrentProgress <= PercentOfTotal()) {
                    strProgressBar += "*";
                } else {
                    strProgressBar += "-";
                }
                //System.out.println(PercentOfTotal());
                intCurrentProgress++;
            }
        } else if (PercentOfTotal() == 5) {
            int intCurrentProgress = 1;
            while (intCurrentProgress <= this.intTotal) {
                if (intCurrentProgress <= PercentOfTotal()) {
                    strProgressBar += "*";
                } else {
                    strProgressBar += "-";
                }
                //System.out.println(PercentOfTotal());
                intCurrentProgress++;
            }
            TimeUnit.SECONDS.sleep(2);
            System.out.println("First Check Point! (only 2 left)");
        } else if (PercentOfTotal() <= 9) {
            int intCurrentProgress = 1;
            while (intCurrentProgress <= this.intTotal) {
                if (intCurrentProgress <= PercentOfTotal()) {
                    strProgressBar += "*";
                } else {
                    strProgressBar += "-";
                }
                //System.out.println(PercentOfTotal());
                intCurrentProgress++;
            }
        } else if (PercentOfTotal() == 10
                && PercentOfTotal() <=14) {
          strProgressBar = "[";
            int intCurrentProgress = 1;
            while (intCurrentProgress <= this.intTotal) {
                if (intCurrentProgress <= PercentOfTotal()) {
                    strProgressBar += "*";
                } else {
                    strProgressBar += "-";
                }
                //System.out.println(PercentOfTotal());
                intCurrentProgress++;
            }
            TimeUnit.SECONDS.sleep(2);
            System.out.println("First Check Point! (only 1 left)");
        } else if (PercentOfTotal() == 15
                && PercentOfTotal() <= 20){
            strProgressBar = "[";
            int intCurrentProgress = 1;
            while (intCurrentProgress <= this.intTotal) {
                if (intCurrentProgress <= PercentOfTotal()) {
                    strProgressBar += "*";
                } else {
                    strProgressBar += "-";
                }
                //System.out.println(PercentOfTotal());
                intCurrentProgress++;
            }
            TimeUnit.SECONDS.sleep(2);
           System.out.println("First Check Point! (no check points left)");
        }
        strProgressBar +="]";
        return strProgressBar;
    }

*/


//sets the number the player has to guess
    private void CorrectNumber(int pCorrectNumber){
        intCorrectNumber = pCorrectNumber;
    }

    public int CorrectNumber() {
        return intCorrectNumber;
    }

}