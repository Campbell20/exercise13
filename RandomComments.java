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
    //an ary of comments for missed guesses
    private ArrayList<String> aryMissedGuessRandomComment = new ArrayList<>();
    //an ary of comments for setting the number to guess
    private ArrayList<String> arySetNumberRandomComment = new ArrayList<>();
    //an ary of comments for guessing the correct number
    private ArrayList<String> aryGuessedCorrectlyRandomComment = new ArrayList<>();

    //this function is where I added all the comments
    public RandomComments(){
        //a list of random comments for missed guesses
        aryMissedGuessRandomComment.add("What were you thinking?!");
        aryMissedGuessRandomComment.add("WHA?!");
        aryMissedGuessRandomComment.add("/FACEPALM");
        aryMissedGuessRandomComment.add("DUUUuuuuuddddeeee!?");
        aryMissedGuessRandomComment.add("Oh My God!");
        aryMissedGuessRandomComment.add("Are you even trying?");
        aryMissedGuessRandomComment.add("Not even close... HA!");
        aryMissedGuessRandomComment.add("WRONG!!");
        aryMissedGuessRandomComment.add("Come on now...");
        aryMissedGuessRandomComment.add("Nope!");
        aryMissedGuessRandomComment.add("NNOOIiiicceee! Is what I would have said... if you had got the number right.");
        aryMissedGuessRandomComment.add("Ummm?");
        aryMissedGuessRandomComment.add("Criminal... How could you?");
        aryMissedGuessRandomComment.add("Are you mistreating me?");

        //a list of random comments for setting the number to guess
        arySetNumberRandomComment.add("Oh boy, you won't be able to guess this!");
        arySetNumberRandomComment.add("Hmm, I know what number you think I'm going to select... so I'm selecting" +
                "This one instead!");
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

    // this function gets a random comment for me to send to the user
    public String GetAMissedGuessComment() {
        int intRandomComment;
        Random objRandomComment = new Random();
        intRandomComment = objRandomComment.nextInt(14) + 1;
        return aryMissedGuessRandomComment.get(intRandomComment);
    }

    public String GetARandomNumberComment(){
        int intRandomComment;
        Random objRandomComment = new Random();
        intRandomComment = objRandomComment.nextInt(8) + 1;
        return arySetNumberRandomComment.get(intRandomComment);
    }

    public String GetAGuessedCorrectlyComment(){
        int intRandomComment;
        Random objRandomComment = new Random();
        intRandomComment = objRandomComment.nextInt(7) + 1;
        return aryGuessedCorrectlyRandomComment.get(intRandomComment);
    }
}
