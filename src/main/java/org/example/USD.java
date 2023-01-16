package org.example;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class USD extends Coin{


    static RestAPI restAPI = new RestAPI();
    boolean correctAmountValue = false;
    private static final double VALUE = restAPI.USDRealValue();
    double coinAmount = 0;



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

//   converting the user's Input from USD to ILS
    @Override
    public double calculate(double value) {
        return getValue()*VALUE;
    }
}