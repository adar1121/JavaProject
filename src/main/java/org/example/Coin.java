package org.example;

public abstract class Coin implements ICalculate{

    @Override
    public double calculate(double value) {
        return 0;
    }

    abstract public double getValue();
}