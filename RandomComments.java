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
    private ArrayList<String> aryFunnyComments = new ArrayList<>(); //an array for funny comments

    //this function is where I added all the comments
    public RandomComments(){
        aryFunnyComments.add("What were you thinking?!");
        aryFunnyComments.add("WHA?!");
        aryFunnyComments.add("/FACEPALM");
        aryFunnyComments.add("DUUUuuuuuddddeeee!?");
        aryFunnyComments.add("Oh My God!?");
        aryFunnyComments.add("Are you even trying?");
        aryFunnyComments.add("WRONG!?");
        aryFunnyComments.add("Come on now...");
        aryFunnyComments.add("Nope!?");
        aryFunnyComments.add("NNOOIiiicceee! Is what I would have said, if you had gotten it right.");
        aryFunnyComments.add("Ummm?");
        aryFunnyComments.add("Criminal... How could you?");
        aryFunnyComments.add("Are you mistreating me?");

    }

    // this function gets a random comment for me to send to the user
    public String GetAComment() {
        int intRandomComment;
        Random objRandomComment = new Random();
        intRandomComment = objRandomComment.nextInt(4) + 1;
        return aryFunnyComments.get(intRandomComment);
    }
}
