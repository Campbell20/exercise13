package com.example;

import java.util.Random;
import java.util.Scanner;


/*
* Name: John Campbell
* Section: COSC/ITSE 
* Homework: exercise 13
* Description: This class runs the entire game. The game is Hi-Lo and players have to guess a number between 1-100.
* If they get it right, the win the round. They get 5 chance to get the number right. I can adjust to to anything
* really. Just having some fun now.
*/

public class HiLoGame {
    private String strInput = "Y";
    private int intRoundCounter;
    private int intWinRoundCounter = 0;
    private int intLoseRoundCounter = 0;
    private int intCorrectNumber;
    private int intHighestNumberToGuess = 5;
    private int intGuessCounter = 0;
    private int intPlayerCurrentGuess;
    int intMaxGuessesAllowed = 5;
    private Random objRandomNumber = new Random();
    private ProgressBar objProgress = new ProgressBar();
    private Scanner objStrOrIntInput = new Scanner(System.in);
    private Scanner objInput = new Scanner(System.in);


    // constructor for the game
    public HiLoGame()  {
         GameRules();
    }

    //sets the number the player has to guess
    private void CorrectNumber(int pCorrectNumber){
        intCorrectNumber = pCorrectNumber;
    }

    private int CorrectNumber() {
        // sets the random number for us each round
        intCorrectNumber = objRandomNumber.nextInt(intHighestNumberToGuess) + 1;
        return intCorrectNumber;
    }

    // game rules for Hi-Lo
    private void GameRules() {
        System.out.println("\n" +
                "\t\t*******************************\n" +
                "\t\t*          Hi-Lo              *\n" +
                "\t\t*        The Video Game       *\n" +
                "\t\t*******************************\n");

        System.out.println("Menu: ");
        System.out.println("Start Game = \"S\" ");
        System.out.println("Rules = \"R\" ");
        strInput = objInput.next().toUpperCase();
       while(true) {
           if (strInput.equals("S")) {
               System.out.println("Launching Game...");
               StartRound();
           } else if (strInput.equals("R")) {
               System.out.println("Rules: ");
               System.out.println("\tYou must guess the correct number from 1 to " + intHighestNumberToGuess + ".");
               System.out.println("\tIf you guess the correct number, you'll win the round!");
               System.out.println("\tYou will be given " + intMaxGuessesAllowed + " attempts to guess the right number.");
               System.out.println("\tThe game will keep tab of your wins and losses.");
               System.out.println("");
               System.out.println("Menu: ");
               System.out.println("Start Game = \"S\" ");
               System.out.println("Rules = \"R\" ");
               strInput = objInput.next().toUpperCase();
           } else {
               System.out.println("You didn't press a valid key, but we're starting anyway!");
               StartRound();
           }
       }
        //  TimeUnit.SECONDS.sleep(1);
    }

    // starts the round
    private void StartRound()  {
        intGuessCounter = 0;
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
        RunRound();
    }

    // runs the game
    private void RunRound()  {
        while(true){
            // cheats
            //System.out.println("Current Guess: " + intPlayerCurrentGuess);
            //System.out.println("Guessed Counter: " + intGuessCounter);
            //System.out.println("Correct Number to Guess: " + intCorrectNumber);

            ToManyGuessesEndRound();
            PlayerCurrentGuess();
            // checks the value of the player's guess vs the correct number and gives the player some hints or
            // tells them they won. I'd like to adjust this to have random print lines.
            if (intPlayerCurrentGuess < intCorrectNumber) {
                System.out.println("You're to low! \n");
                System.out.println("Game Stats: ");
                System.out.println("Round Wins: " + intWinRoundCounter + " Round Losses: " + intLoseRoundCounter);
                System.out.println("Life Bar: " + objProgress.RenderBar());
                intGuessCounter++;
                //objPlayer.CurrentGuess();
            } else if (intPlayerCurrentGuess > intCorrectNumber) {
                System.out.println("You're to high! \n");
                System.out.println("Game Stats: ");
                System.out.println("Round Wins: " + intWinRoundCounter + " Round Losses: " + intLoseRoundCounter);
                System.out.println("Life Bar: " + objProgress.RenderBar());
                intGuessCounter++;
            } else if (intPlayerCurrentGuess == intCorrectNumber) {
                intGuessCounter++;
                WonRound();
            }
        }

    }

    // player wins the round
    private void WonRound()  {
        System.out.println("The number was " + intCorrectNumber);
        System.out.println("You guessed correctly!");
        System.out.println("It only took you " + intGuessCounter +
                " guesses until you got the number correct.");
        System.out.println("");
        System.out.println("");
        intWinRoundCounter++;
        EndRound();
    }

    // player guessed to many times
    private void ToManyGuessesEndRound()  {
        if(intGuessCounter == intMaxGuessesAllowed) {
            System.out.println("You ran out of guesses and did not guess the random number correctly!");
            System.out.println("The number was " + CorrectNumber());
            System.out.println("");
            intLoseRoundCounter++;
            EndRound();
        }
    }

    // is the round over?
    private void EndRound() {
        System.out.println("Round " + intRoundCounter + " complete.");
        System.out.println("");
        System.out.println("Did you want to play another round?");
        System.out.println("Type \"Y\" to keep playing or anything else to quit.");
        strInput = objInput.next().toUpperCase();
        System.out.println(strInput);
        if (strInput.equals("Y")) {
            GameRules();
        } else
            EndGame();
    }

    // asks the player if they want to end the game.
    private void EndGame(){
        System.out.println("Did you want to quit the game?");
        System.out.println("Type \"Y\" to keep playing or anything else to quit.");
        strInput = objInput.next().toUpperCase();
        if (strInput.equals("Y")) {
           StartRound();
        } else
            System.out.println("Good Bye!");
            System.exit(0);
    }


    //asks the player for a value and ends the round if the player types anything other than a value
    public void PlayerCurrentGuess()  {
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

}