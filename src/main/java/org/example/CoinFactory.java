package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CoinFactory extends Coin {
    private MessageFactory messageFactory = new MessageFactory();
    private ILS ils = new ILS();
    private USD usd = new USD();
    private Coins coins;
    private StartOver startOver;
    private int resultsIndexSaver = 0;
    private String resultsPrinter = "";
    private String resultsIndexCoinSaver;
    private String startOverLetterInput;
    private ArrayList<Double> resultSaver = new ArrayList<>();
    private ArrayList<Double> amountSaver = new ArrayList<>();
    private ArrayList<String> coinTypeResultSaver = new ArrayList<>();
    private  ArrayList<String> oppositeCoinTypeResultSaver = new ArrayList<>();
    private boolean currencyConverterSwitchON = true;
    @Override
    public double getValue() {
        return 0;
    }

    public void currencyConverterSwitch(){
        while (currencyConverterSwitchON == true) {
            messageFactory.chooseTypeCoinMessage();
            getInputCoinType();
            messageFactory.enterAmountMessage();
            coinTypeOrder();
            messageFactory.askToStartOver();
            if (startOverQuestion() == String.valueOf(StartOver.N)){
                currencyConverterSwitchON = false;
            }
        }
    }

//   Asking the user to Start over again
    public String startOverQuestion(){
        boolean startOverCorrectAnswer = false;

        while (startOverCorrectAnswer == false) {

            try {
                Scanner scanner = new Scanner(System.in);
                startOverLetterInput = scanner.next();
                startOver = StartOver.valueOf(startOverLetterInput.toUpperCase());
                if(startOver == StartOver.N | startOver == StartOver.Y);
                {
                    startOverCorrectAnswer = true;
                }
            }catch (Exception e){
                System.out.println("Invalid Choice, please try again");
            }
        }
            return String.valueOf(startOver);
    }

//   User enter Type 1 or 2 for Choose type coin
    public Coins getInputCoinType() {
        boolean typeIsCorrect = false;
        while (typeIsCorrect == false) {
            try {
                Scanner scanner = new Scanner(System.in);
                coins = Coins.values()[(scanner.nextInt() - 1)];
                if (coins == Coins.USD | coins == Coins.ILS) {
                    typeIsCorrect = true;
                }
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("Invalid Choice, please try again");
            }
        }
        return coins;
    }


//  converting the coin and save result and user's amount input
    public void coinTypeOrder() {
            switch (coins) {
                case USD:
                    usd.correctAmountValue = false;
                    double USDToILSResult = usd.calculate(usd.coinAmount);
                    System.out.println(usd.coinAmount + " USD = " + USDToILSResult + " ILS");
                    amountSaver.add(resultsIndexSaver, usd.coinAmount);
                    resultSaver.add(resultsIndexSaver, USDToILSResult);
                    coinTypeResultSaver.add(resultsIndexSaver, " USD");
                    oppositeCoinTypeResultSaver.add(resultsIndexSaver, " ILS");
                    resultsIndexSaver++;
                    break;

                case ILS:
                    ils.correctAmountValue = false;
                    double ILSToUSDResult = ils.calculate(ils.coinAmount);
                    System.out.println(ils.coinAmount + " ILS = " + ILSToUSDResult + " USD");
                    amountSaver.add(resultsIndexSaver, ils.coinAmount);
                    resultSaver.add(resultsIndexSaver, ILSToUSDResult);
                    coinTypeResultSaver.add(resultsIndexSaver, " ILS");
                    oppositeCoinTypeResultSaver.add(resultsIndexSaver, " USD");
                    resultsIndexSaver++;
                    break;
            }
    }

//   save and print all the previous results
    public void printAllResults(){
        for (int i = 0; i < resultsIndexSaver; i++){
            resultsPrinter = resultsPrinter +amountSaver.get(i).toString() +coinTypeResultSaver.get(i).toString()
                    +  " = " + resultSaver.get(i).toString()  + oppositeCoinTypeResultSaver.get(i).toString() + "\n";
        }
        System.out.println(resultsPrinter);
    }

//   Print and save all results to Text File at Project Path
    public void printAllResultsToText(){
        String filePath = "Results.txt";
        try {
            Files.writeString(Paths.get(filePath),resultsPrinter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}