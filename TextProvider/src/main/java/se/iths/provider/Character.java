package se.iths.provider;

import se.iths.service.StringCalculator;
import se.iths.service.annotation.Type;
import se.iths.service.annotation.Calculate;

@Calculate(Type.CHARACTER)
public class Character implements StringCalculator {
    @Override
    public int calculate(String stringToCalculate) {
        return stringToCalculate.length();
    }
}
