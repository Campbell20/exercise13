package com.example;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
* Name: John Campbell
* Section: COSC/ITSE 
* Homework: exercise 13
* Description: This class runs the entire game. The game is Hi-Lo and players have to guess a number between 1-100.
* If they get it right, the win the round. They get 5 chance to get the number right. I can adjust to to anything
* really. Just having some fun now.
*/

public class HiLoGame {
    private String strInput = "Y"; //String style input variable

    private int intRoundCounter; //a counter for each of the rounds
    private int intWinRoundCounter = 0; // a counter for each win the player gets
    private int intLoseRoundCounter = 0; // a counter for each loss the player gets
    private int intGuessCounter = 0;  // a counter for the amount of guesses of a round
    int intTotalGuessesCounter = 0; //a counter for the total amount of guess for the entire game
    int intMaxGuessesAllowed = 10; // how many guesses does the player get? ADJUST ProgressBar.java as well!!!
    private int intPlayerCurrentGuess; // player's current guessed number
    private int intCorrectNumber;  // the variable for the number the player needs to guess
    private int intHighestNumberToGuess = 100; // the highest number the random number generator will create

    private Random objRandomNumber = new Random(); // random number generator for number to guess
    private ProgressBar objProgress = new ProgressBar(); // progess bar
    private RandomComments objComments = new RandomComments(); // for funny comments
    private Scanner objStrOrIntInput = new Scanner(System.in); //input command for string or int
    private Scanner objInput = new Scanner(System.in); //our input command for everything else


    // constructor for the game
    public HiLoGame() throws InterruptedException {
         StartGame();
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

    // starts the game
    private void StartGame() throws InterruptedException{
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
               System.out.println("\tIf you guess the correct number within the allowed attempts, " +
                       "you'll win the round!");
               System.out.println("\tYou will be given " + intMaxGuessesAllowed +
                       " attempts for each round to guess the right number during that round.");
               System.out.println("\tAt the end of each round, the game will tell you your game stats.");
               System.out.println("\tKeep playing for as long as you'd like, and at anytime you can quit by typing" +
                       " anything that is not a number.");
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
    }

    // starts the round
    private void StartRound()  throws InterruptedException {
        intGuessCounter = 0;  // resets the guess counter
        objProgress.ResetBar(); //resets the progress bar
        intRoundCounter++; //adds +1 to round counter

       // adding a bit of space between anything before round start and text below
        System.out.println("");

        // letting the player know the program reset their progress bar
        System.out.println("Resetting your guess amount to: " + objProgress.RenderBar());
        TimeUnit.SECONDS.sleep(1);
        // letting the player know the program set a random number for them and that they can start the round
        System.out.println("Setting the number to guess...");
        //generates and sets a random number
        CorrectNumber(CorrectNumber());
        TimeUnit.SECONDS.sleep(1);
        //give the player a random comment for setting the number (gives the computer a bit of a personality).
        System.out.println(objComments.GetARandomNumberComment());
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Number set. Can you guess it? Good luck!");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Round " + intRoundCounter + " Begin!\n");
        TimeUnit.SECONDS.sleep(1);

        // runs the round
        RunRound();
    }

    // runs the game
    private void RunRound() throws InterruptedException  {
        while(intGuessCounter <= intMaxGuessesAllowed){
            // cheats
            //System.out.println("Current Guess: " + intPlayerCurrentGuess);
            //System.out.println("Guessed Counter: " + intGuessCounter);
            //System.out.println("Correct Number to Guess: " + intCorrectNumber);

            ToManyGuessesEndRound(); // did the player burn up all his guesses? This checks that...
            PlayerCurrentGuess();  // What is the player's current guess?
            intGuessCounter++;  // add one to guesses (this counter resets each round)
            intTotalGuessesCounter++; //add one to guesses (this counter does not reset)

            // checks the value of the player's guess vs the correct number and gives the player some hints or
            // tells them they won. I'd like to adjust this to have random print lines.
            if (intPlayerCurrentGuess < intCorrectNumber) {
                System.out.println(objComments.GetAMissedGuessComment() + " You're to low!");
                //a short timeout to let the player read the comments
                TimeUnit.SECONDS.sleep(2);
                System.out.println("");
                //a hint for the player
                System.out.println("Try a HIGHER number.");
                // progress bar
                System.out.println("Guesses Remaining: " + objProgress.RenderBar());
            } else if (intPlayerCurrentGuess > intCorrectNumber) {
                System.out.println(objComments.GetAMissedGuessComment() + " You're to high!");
                //a short timeout to let the player read the comments
                TimeUnit.SECONDS.sleep(2);
                System.out.println("");
                //a hint for the player
                System.out.println("Try a LOWER number.");
                // progress bar
                System.out.println("Guesses Remaining: " + objProgress.RenderBar());
            } else if (intPlayerCurrentGuess == intCorrectNumber) {
                //give the player a random comment for guessing correctly
                objComments.GetAGuessedCorrectlyComment();
                TimeUnit.SECONDS.sleep(2);
                //launch the round won function
                WonRound();
            }
        }

    }

    // player wins the round
    private void WonRound()  throws InterruptedException {
        System.out.println("OH NO! I lost!");
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
    private void ToManyGuessesEndRound() throws InterruptedException {
        if(intGuessCounter == intMaxGuessesAllowed) {
            System.out.println("HAH! I won!");
            System.out.println("");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("You ran out of guesses and did not guess the random number correctly!");
            System.out.println("The number was " + CorrectNumber());
            System.out.println("");
            intLoseRoundCounter++;
            EndRound();
        }
    }

    // is the round over?
    private void EndRound() throws InterruptedException{
        System.out.println("Round " + intRoundCounter + " complete.");
        System.out.println("");
        // shows the player's stats
        PlayerStats();
        System.out.println("Did you want to play another round?");
        System.out.println("Type \"Y\" to keep playing or anything else to quit.");
        strInput = objInput.next().toUpperCase();
        System.out.println(strInput);
        if (strInput.equals("Y")) {
            StartRound();
        } else
            EndGame();
    }

    // asks the player if they want to end the game.
    private void EndGame() throws InterruptedException {
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
    public void PlayerCurrentGuess() throws InterruptedException {
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

    //what are the player's current stats? (guesses, wins, losses, etc)
    private void PlayerStats(){

        System.out.println("Game Stats: ");
        System.out.println("Wins: " + intWinRoundCounter + " | Losses: " + intLoseRoundCounter);
        System.out.println("Rounds: " + intRoundCounter);
        System.out.println("Guesses used this round: " + intGuessCounter);
        System.out.println("Total Guesses used: " + intTotalGuessesCounter);

    }

}