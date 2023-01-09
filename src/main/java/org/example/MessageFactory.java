package org.example;

public class MessageFactory {
//   welcome message
    public void introductionMessage(){
        System.out.println("Welcome to currency converter");
    }

//  asking the user to choose a coin to convert
    public void chooseTypeCoinMessage(){
        System.out.println("Please choose an option (1/2): \n1. Dollars to Shekels \n2. Shekels to Dollars"  );
    }
//   asking the amount of the specific coin
    public void enterAmountMessage(){
        System.out.println("Please enter an amount to convert: ");
    }

//  asking the user to start over
    public void askToStartOver(){
        System.out.print("You want to start over? Y/N: ");
    }

//   printing thanks before ending the currency converter program
    public void endScreenMessage(){
        System.out.println("Thanks for using our currency converter");
    }
}
