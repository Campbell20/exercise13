package com.example;

import java.util.Scanner;

/*
* Name: John Campbell
* Section: COSC/ITSE 
* Homework: exercise 13
* Description: This class gives the ability to have the player put in their name. Then the computer will talk back to
 * them using their name.
*/
public class Player {
    private String strPlayerName = "John";
    private String strAccept = "N";
    private Scanner objInput = new Scanner(System.in);

    //constructor for player
    public Player(){
    }

    // create player name from their input
    private String PlayerNameFromInput() {
        while (strAccept.equals("N")) {
            System.out.println("What is your name, player?");
            strPlayerName = objInput.next();
            System.out.println("Player name set as: " + strPlayerName);
            System.out.println("Is this correct? Type \"Y\" to accept or anything else to retype your name");
            strAccept = objInput.next().toUpperCase();
        }
        return strPlayerName;
    }

    // sets player name for other functions
    private void PlayerNameFromInput(String pstrPlayerName){
        strPlayerName = pstrPlayerName;
    }

    // put this function into other classes
    public void GetPlayerName(){
        PlayerNameFromInput(PlayerNameFromInput());
    }

    // once the player's name is set, this function will print out their name
    public String PlayerNameCalledOut(){
        return strPlayerName;
    }

}
