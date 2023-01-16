package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ILS extends Coin{

    private static RestAPI restAPI = new RestAPI();

    boolean correctAmountValue = false;
    private static final double VALUE = restAPI.ILSRealValue();
    double coinAmount = 0;

    //   converting the user's Input from ILS to USD
    @Override
    public double calculate(double value) {
        return getValue()*VALUE;
    }

    //   receive USD Input amount from user
    @Override
    public double getValue() {
        while (correctAmountValue == false) {
            try {
                Scanner scanner = new Scanner(System.in);
                coinAmount = scanner.nextDouble();
                correctAmountValue = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Choice, please try again");
            }

        }
        return coinAmount;
    }
}