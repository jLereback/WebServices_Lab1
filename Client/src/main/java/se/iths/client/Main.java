package se.iths.client;

import se.iths.service.annotation.Calculate;
import se.iths.service.StringCalculator;
import se.iths.service.annotation.Type;

import java.util.List;
import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String choice;
        do {
            printMenu();
            choice = sc.nextLine().toLowerCase();
            switchMenu(choice);
        } while (!choice.equals("e"));

    }

    public static void printMenu() {
        System.out.println("""
  
                Welcome to String Calculator!
                =============================
                What would you like to calculate:
                1. Characters
                2. Sentences
                3. Words
                e. Quit
                """);
    }

    private static void switchMenu(String choice) {

        switch (choice) {
            case "1" -> letter();
            case "2" -> sentence();
            case "3" -> word();
            case "e" -> quit();
            default -> System.out.println("Please choose one of the alternatives below:");
        }
    }

    private static void letter() {
        askForString();
        calculateLetters(sc.nextLine());
    }

    private static void sentence() {
        askForString();
        calculateSentences(sc.nextLine());
    }

    private static void word() {
        askForString();
        calculateWords(sc.nextLine());
    }

    private static List<StringCalculator> getCalculation(Type typeToCalc) {
        ServiceLoader<StringCalculator> serviceLoader = ServiceLoader.load(StringCalculator.class);
        return serviceLoader.stream()
                .filter(c -> c.type().isAnnotationPresent(Calculate.class)
                        && c.type().getAnnotation(Calculate.class)
                        .value()
                        .equals(typeToCalc))
                .map(ServiceLoader.Provider::get)
                .toList();
    }

    private static void calculateLetters(String stringToCalculate) {
        for (var string : getCalculation(Type.CHARACTER)) {
            System.out.println("The string contains " + string.calculate(stringToCalculate) + " character(s)");
        }
    }

    private static void calculateSentences(String stringToCalculate) {
        for (var string : getCalculation(Type.SENTENCE)) {
            System.out.println("The string contains " + string.calculate(stringToCalculate) + " sentence(s)");
        }
    }

    private static void calculateWords(String stringToCalculate) {
        for (var string : getCalculation(Type.WORD)) {
            System.out.println("The string contains " + string.calculate(stringToCalculate) + " word(s)");
        }
    }

    private static void askForString() {
        System.out.println("Please insert the string you want to calculate");
    }

    private static void quit() {
        System.out.println("Thank you for using my service");
    }
}
