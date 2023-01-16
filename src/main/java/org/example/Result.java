package org.example;

public class Result {
    private String resultKeeper;
    private double amountInputKeeper;

    Result(double amountInput,String result){
    this.amountInputKeeper = amountInput;
    this.resultKeeper = result;
    }

    public double getAmountInput(){
        return amountInputKeeper;
    }
    public String getResult(){
        return resultKeeper;
    }


}
