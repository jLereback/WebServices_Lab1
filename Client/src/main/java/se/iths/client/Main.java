package se.iths.client;

import se.iths.service.StringCalculator;
import se.iths.service.annotation.Calculate;
import se.iths.service.annotation.Type;

import java.util.List;
import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = Integer.parseInt(sc.nextLine());
            calculateType(choice);
        } while (choice != 0);
    }

    public static void printMenu() {
        System.out.printf("""
                  
                Welcome to String Calculator!
                =============================
                What would you like to calculate:
                0. Quit
                %s
                """, printOptions());
    }

    private static StringBuilder printOptions() {
        StringBuilder options = new StringBuilder();
        for (int i = 0; i < getTypes().size(); i++)
            options.append(i + 1).append(". ").append(getTypes().get(i)).append("\n");
        return options;
    }

    private static List<Type> getTypes() {
        return ServiceLoader.load(StringCalculator.class)
                .stream()
                .filter(c -> c.type().isAnnotationPresent(Calculate.class))
                .map(c -> c.type().getAnnotation(Calculate.class).value())
                .toList();
    }

    private static void calculateType(int choice) {
        if (choice == 0)
            quit();
        else {
            askForString();
            calculateString(Type.values()[choice - 1], sc.nextLine());
        }
    }

    private static void calculateString(Type type, String stringToCalc) {
        for (var string : getCalculation(type))
            System.out.printf("The string contains %s %s(s)\n",
                    string.calculate(stringToCalc), type.toString().toLowerCase());
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

    private static void askForString() {
        System.out.println("Please insert the string you want to calculate");
    }

    private static void quit() {
        System.out.println("Thank you for using my service");
    }
}
