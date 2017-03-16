package com.example;

import java.util.ArrayList;
import java.util.Random;

/*
* Name: John Campbell
* Section: COSC/ITSE 
* Homework:
* Description: HAHA! This was a test of the arraylist. I made the program spit out a bunch of random messages to the
* player if he gets the number wrong.
*/
public class RandomComments {
    // getting the player's name for some of the random comments
    private Player objPlayersName = new Player();
    //an ary of comments for missed guesses
    private ArrayList<String> aryMissedGuessRandomComment = new ArrayList<>();
    //an ary of comments for setting the number to guess
    private ArrayList<String> arySetNumberRandomComment = new ArrayList<>();
    //an ary of comments for guessing the correct number
    private ArrayList<String> aryGuessedCorrectlyRandomComment = new ArrayList<>();

    //using the contstructor as a location for all of the random comments
    public RandomComments() throws InterruptedException {
        //a list of random comments for missed guesses
        aryMissedGuessRandomComment.add(objPlayersName.PlayerNameCalledOut() + ", what were you thinking?!");
        aryMissedGuessRandomComment.add("WHA?! HAHA!");
        aryMissedGuessRandomComment.add("Maybe I made this too hard for you?");
        aryMissedGuessRandomComment.add("DUUUuuuuuddddeeee!?");
        aryMissedGuessRandomComment.add("Oh my god " + objPlayersName.PlayerNameCalledOut() + " You're not even " +
                        "guessing, are you?");
        aryMissedGuessRandomComment.add("Are you even trying " + objPlayersName.PlayerNameCalledOut() + "?");
        aryMissedGuessRandomComment.add("Not even close... HA!");
        aryMissedGuessRandomComment.add("WRONG!!");
        aryMissedGuessRandomComment.add("Come on now " + objPlayersName.PlayerNameCalledOut() + "...");
        aryMissedGuessRandomComment.add("Nope!");
        aryMissedGuessRandomComment.add("NNIiiicceee! Is what I would have said... Had you got the number right.");
        aryMissedGuessRandomComment.add("Ummm? Hello?");
        aryMissedGuessRandomComment.add("Getting warmer...");
        aryMissedGuessRandomComment.add("Are you wasting my time " + objPlayersName.PlayerNameCalledOut() + "?");

        //a list of random comments for setting the number to guess
        arySetNumberRandomComment.add("Oh boy, you won't be able to guess this!");
        arySetNumberRandomComment.add("Hmm, I know what number you think I'm going to select... so I'm selecting" +
                " this one instead!");
        arySetNumberRandomComment.add("Let's see... Oh yes; this is good number. HAHA!");
        arySetNumberRandomComment.add("Hmmm...");
        arySetNumberRandomComment.add("I bet you won't be able to guess this one...");
        arySetNumberRandomComment.add("I know just the number to set.");
        arySetNumberRandomComment.add("You may have to become a mathematician to get this one...");
        arySetNumberRandomComment.add("Even with all your guess attempts, you won't get this one!");

        //a list of random comments for guessing the correct number
        aryGuessedCorrectlyRandomComment.add("How did... Wha?... NO WAY!");
        aryGuessedCorrectlyRandomComment.add("That's impossible!");
        aryGuessedCorrectlyRandomComment.add("Did you read my mind?");
        aryGuessedCorrectlyRandomComment.add("You... I... NNNNNnnooooooo!!!!");
        aryGuessedCorrectlyRandomComment.add("I can't believe it!");
        aryGuessedCorrectlyRandomComment.add("Well done.... well done.");
        aryGuessedCorrectlyRandomComment.add("Nice work!");
    }

    // this function gets a random comment for me to send to the user when they guess wrong
    public String GetAMissedGuessComment() {
        int intRandomComment;
        Random objRandomComment = new Random();
        intRandomComment = objRandomComment.nextInt(13);
        return aryMissedGuessRandomComment.get(intRandomComment);
    }

    // this function gets a random comment for me to send to the user when the computer sets a random number
    public String GetARandomNumberComment(){
        int intRandomComment;
        Random objRandomComment = new Random();
        intRandomComment = objRandomComment.nextInt(7);
        return arySetNumberRandomComment.get(intRandomComment);
    }

    // this function gets a random comment for me to send to the user when they guessed the number correctly
    public String GetAGuessedCorrectlyComment(){
        int intRandomComment;
        Random objRandomComment = new Random();
        intRandomComment = objRandomComment.nextInt(7);
        return aryGuessedCorrectlyRandomComment.get(intRandomComment);
    }
}
