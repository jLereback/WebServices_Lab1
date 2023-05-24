package se.iths.provider;

import se.iths.service.StringCalculator;

public class Word implements StringCalculator {
    @Override
    public int calculate(String stringToCalculate) {
        return stringToCalculate.split(" ").length;
    }
}
