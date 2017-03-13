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
    private int intEndRound = 0;
    private int intRoundCounter;
    private int intPlayerCurrentGuess = 0;
    private int intCorrectNumber;
    private int intGuess;
    private int intMaxGuessesAllowed = 5;
    private int intHighestNumberToGuess = 5;

    Scanner objInput = new Scanner(System.in);
    Scanner objStrOrIntInput = new Scanner(System.in);
    ProgressBar objProgress = new ProgressBar();


    // constructor for the game
    public void HiLoGame() throws InterruptedException {
        //reads the game rules to the player
        GameRules();
        //starts the game for the player
        StartRound();
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
        System.out.println("\tYou must guess the correct number from 1 to " + intHighestNumberToGuess + ".");
        System.out.println("\tYou will be given 20 attempts to guess the right number.");
        //  TimeUnit.SECONDS.sleep(1);
    }

    // starts the round
    private void StartRound() throws InterruptedException {
        //resetting the end round boolean
        intEndRound = 0;
        //reset current guesses
        intGuess = 0;
        // reset the progress bar
        objProgress.ResetBar();
        //adds 1 more to round counter
        intRoundCounter++;
       // adding a bit of space between rules/objectives/etc, and game start
        System.out.println("");
        System.out.println("");
        // letting the player know the program set a random number for them and that they can start the game
        System.out.println("Setting the number to guess...");
        //generates and sets a random number
        CorrectNumber(CorrectNumber());
        // time out for fun
        // TimeUnit.SECONDS.sleep(2);
        System.out.println("Number set. Can you guess it? Good luck!");
        System.out.println("Round " + intRoundCounter + " Begin!\n");
    }

    // runs the game
    private void RunRound() throws InterruptedException {
        while (intEndRound == 0) {
            // checks the value of the player's guess vs the correct number and gives the player some hints or
            // tells them they won. I'd like to adjust this to have random print lines.
            if (intPlayerCurrentGuess < intCorrectNumber) {
                System.out.println("You're to low! ");
                GuessCounter();
                PlayerCurrentGuess();
                //checks to see if the player guessed to many times
                ToManyGuessesEndRound();
            } else if (intPlayerCurrentGuess > intCorrectNumber) {
                System.out.println("You're to high! ");
                GuessCounter();
                PlayerCurrentGuess();
                //checks to see if the player guessed to many times
                ToManyGuessesEndRound();
            } else {
                GuessCounter();
                PlayerCurrentGuess();
                WonRound();
            }
        }
    }

    private void GuessCounter(){
        //adds 1 more to current guess number
        intGuess++;
        //renders the progress bar
        System.out.println(objProgress.RenderBar());
    }
    // player guessed to many times
    private void ToManyGuessesEndRound() throws InterruptedException {
        if(intGuess == intMaxGuessesAllowed) {
            System.out.println("You ran out of guesses and did not guess the random number correctly!");
            System.out.println("The number was " + intCorrectNumber);
            System.out.println("");
            EndRound();
        }
    }

    // player wins the round
    private void WonRound() throws InterruptedException {
        System.out.println("The number was " + intCorrectNumber);
        System.out.println("You guessed correctly!");
        System.out.println("It only took you " + intGuess + " guesses until you got the number correct.");
        System.out.println("");
        System.out.println("");
        EndRound();
    }

    private void EndRound() throws InterruptedException {
        intEndRound = 1;
        System.out.println("Round " + intRoundCounter + " complete.");
        System.out.println("");
        System.out.println("Did you want to play another round?");
        System.out.println("Type \"Y\" to keep playing or anything else to quit.");
        strInput = objInput.next().toUpperCase();
        System.out.println(strInput);
        if (strInput.equals("Y")) {
            StartRound();
        } else
            EndGame();
    }

    private void EndGame() throws InterruptedException {
        System.out.println("Did you want to quit the game?");
        System.out.println("Type \"Y\" to keep playing or anything else to quit.");
        strInput = objInput.next().toUpperCase();
        if (strInput.equals("Y")) {
           EndRound();
        } else
            System.out.println("Good Bye!");
            System.exit(0);
    }

    //asks the player for a value and ends the round if the player types anything other than a value
    private void PlayerCurrentGuess() throws InterruptedException {
        String strPlayerGuessInput;
        // asks the user to guess a number
        System.out.println("What number would you like to guess? ");
        strPlayerGuessInput = objStrOrIntInput.next().toUpperCase();
        // checks to see if the input is an integer. If so, then it plays that integer,
        // if not, then it ends the round for the player.
        try {
            int intActualIntegerInput = Integer.parseInt(strPlayerGuessInput);
            System.out.println("You guessed: " + intActualIntegerInput);
            // convert's player integer into the class variable for other functions
            intPlayerCurrentGuess = intActualIntegerInput;
        } catch (NumberFormatException nFE) {
            System.out.println("You typed in something other than a number!");
            System.out.println("This automatically ended the round for you.");
            EndRound();
        }
    }

//sets the number the player has to guess
    private void CorrectNumber(int pCorrectNumber){
        intCorrectNumber = pCorrectNumber;
    }

    private int CorrectNumber() {
        // sets the random number for us each round
        Random objRandomNumber = new Random();
        intCorrectNumber = objRandomNumber.nextInt(intHighestNumberToGuess) + 1;
        return intCorrectNumber;
    }

}