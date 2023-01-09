package org.example;
public class Main {
    public static void main(String[] args) {
        CoinFactory coinFactory = new CoinFactory();
        MessageFactory messageFactory = new MessageFactory();

        messageFactory.introductionMessage();

        coinFactory.currencyConverterSwitch();

        messageFactory.endScreenMessage();

        coinFactory.printAllResults();

        coinFactory.printAllResultsToText();
    }
}