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
    private String strInput = "Y";
    private int intPlayerEndRound;
    private int intQuit;
    private int intPlayerCurrentGuess;
    private int intCorrectNumber;
    private int intGuess;
    private int intHighestNumberToGuess = 5;

    Scanner objInput = new Scanner(System.in);
    ProgressBar objProgress = new ProgressBar();


    // constructor for the game
    public void HiLoGame() throws InterruptedException {
        //reads the game rules to the player
        GameRules();
        //starts the game for the player
        StartGame();
        // keeps running the game until the player quits
        RunRound();

    }

    // game rules for Hi-Lo
    private void GameRules() throws InterruptedException {
        System.out.println("\n" +
                "\t\t*******************************\n" +
                "\t\t*          Hi-Lo              *\n" +
                "\t\t*        The Video Game       *\n" +
                "\t\t*******************************\n\n");
        System.out.println("Objective: ");
        System.out.println("\tYou must guess the correct number from 1 to" + intHighestNumberToGuess + ".");
        System.out.println("\tYou will be given 20 attempts to guess the right number.");
        //  TimeUnit.SECONDS.sleep(1);
    }

    // starts the game for the user by setting a random number that they need to guess
    private void StartGame() throws InterruptedException {
        // resetting guess and quit back to default values
        intQuit = 0;
        intGuess = 0;
        // adding a bit of space between rules/objectives/etc, and game start
        System.out.println("");
        System.out.println("");

        // letting the player know the program set a random number for them
        System.out.println("Setting the number to guess...");
        //generates and sets a random number
        CorrectNumber(CorrectNumber());
        // time out for fun
        // TimeUnit.SECONDS.sleep(2);
        System.out.println("Number set. Can you guess it? Good luck!\n\n");

    }

    // runs the game
    private void RunRound() throws InterruptedException {
        while (intQuit == 0) {
            //adds 1 more to current guess number
            intGuess++;
            //runs current guess function to ask the player for a number value
            CurrentGuess();
            System.out.println(objProgress.RenderBar());
            // checks the value of the player's guess vs the correct number and gives the player some hints
            // tells the player they're too low
            if (intPlayerCurrentGuess < intCorrectNumber) {
                System.out.println("You're to low! ");
                // tells the player they're to high
            } else if (intPlayerCurrentGuess > intCorrectNumber) {
                System.out.println("You're to high! ");
                // tells the player they have won!
            } else {
                WonRound();
            }
        }
    }

    // player wins the round
    private void WonRound() throws InterruptedException {
        System.out.println("The number was " + intCorrectNumber);
        System.out.println("You guessed correctly!");
        System.out.println("It only took you " + intGuess + " guesses until you got the number correct.");
     //   PlayerEndRound(PlayerEndRound());
    }

    // player ends the round early by not typing in an integer
    private void PlayerEndRound(int pPlayerEndRound){
        intPlayerEndRound = pPlayerEndRound;
    }

    private int PlayerEndRound() throws InterruptedException {
       System.out.println("Did you want to quit?");
       System.out.println("Type \"Y\" to keep playing or anything else to quit.");
       strInput = objInput.next();
       if (strInput.equals("Y")) {
           StartGame();
           return intQuit = 0;
       } else
           return intQuit = 1;
   }


    //Adds +1 to guess number (used to determine if the round is over by guessing too much),
    //and constantly checks to see if player wants to quit round
    private void CurrentGuess() throws InterruptedException {
        String strCurrentGuess;
        int intLocalCurrentGuess;

        // asks the user to guess a number
        System.out.println("What number would you like to guess? ");

        strCurrentGuess = objInput.next().toUpperCase();
        try {
            int intCurrentGuess = Integer.parseInt(strCurrentGuess);
            System.out.println(intCurrentGuess);
            intLocalCurrentGuess = intCurrentGuess;
            intPlayerCurrentGuess = intLocalCurrentGuess;
        } catch (NumberFormatException nFE) {
            System.out.println("You typed in something other than a number.");
            PlayerEndRound(PlayerEndRound());
        }
    }




//sets the number the player has to guess
    private void CorrectNumber(int pCorrectNumber){
        intCorrectNumber = pCorrectNumber;
    }

    public int CorrectNumber() {
        // sets the random number for us each round
        Random objRandomNumber = new Random();
        intCorrectNumber = objRandomNumber.nextInt(intHighestNumberToGuess) + 1;
        return intCorrectNumber;
    }

}