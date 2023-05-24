package se.iths.provider;

import se.iths.service.StringCalculator;
import se.iths.service.Type;
import se.iths.service.TypeOfCalc;

public class Sentence implements StringCalculator {
    @Override
    @TypeOfCalc(Type.SENTENCE)
    public int calculate(String stringToCalculate) {
        return stringToCalculate.split("\\.").length;
    }
}
