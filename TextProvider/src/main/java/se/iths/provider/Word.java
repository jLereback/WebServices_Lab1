package se.iths.provider;

import se.iths.service.StringCalculator;
import se.iths.service.annotation.Type;
import se.iths.service.annotation.Calculate;

@Calculate(Type.WORD)
public class Word implements StringCalculator {
    @Override
    public int calculate(String stringToCalculate) {
        return stringToCalculate.split("\\W+").length;
    }
}
