package se.iths.provider;

import se.iths.service.StringCalculator;
import se.iths.service.Type;
import se.iths.service.Calculate;

@Calculate(Type.SENTENCE)
public class Sentence implements StringCalculator {
    @Override
    public int calculate(String stringToCalculate) {
        return stringToCalculate.split("\\.").length;
    }
}
