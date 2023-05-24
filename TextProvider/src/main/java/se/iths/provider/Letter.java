package se.iths.provider;

import se.iths.service.StringCalculator;
import se.iths.service.Type;
import se.iths.service.TypeOfCalc;

public class Letter implements StringCalculator {
    @Override
    @TypeOfCalc(Type.LETTER)
    public int calculate(String stringToCalculate) {
        return stringToCalculate.length();
    }
}
