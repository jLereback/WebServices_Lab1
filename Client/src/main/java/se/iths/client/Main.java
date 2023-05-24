package se.iths.client;

import se.iths.provider.Letter;
import se.iths.provider.Sentence;
import se.iths.provider.Word;

import java.util.Scanner;

public class Main {
/*    public static void main(String[] args) {
        Letter letter = new Letter();
        System.out.println(letter.calculate("This is a string. This is also a string"));
        Word word = new Word();
        System.out.println(word.calculate("This is a string. This is also a string"));
        Sentence sentence = new Sentence();
        System.out.println(sentence.calculate("This is a string. This is also a string"));
    }*/

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
                                
                Welcome to Disc Shop!
                =====================
                What would you like to count:
                1. Letters
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
        String stringToCalc = sc.nextLine();

        Letter letter = new Letter();
        System.out.println(letter.calculate(stringToCalc));
    }

    private static void sentence() {
        askForString();
        String stringToCalc = sc.nextLine();

        Sentence sentence = new Sentence();
        System.out.println(sentence.calculate(stringToCalc));
    }

    private static void word() {
        askForString();
        String stringToCalc = sc.nextLine();

        Word word = new Word();
        System.out.println(word.calculate(stringToCalc));
    }

    private static void askForString() {
        System.out.println("Please insert the string you want to calculate");
    }

    private static void quit() {
        System.out.println("Thank you for using my service");
    }
}
