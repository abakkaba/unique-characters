package main;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string to calculate characters: ");
        String input = scanner.nextLine();

        while (!input.isEmpty()) {
            System.out.println(CharactersCalculator.doCalculations(input));
            System.out.print("Let's do it again: ");
            input = scanner.nextLine();
        }

        System.out.println("Exiting...");
        scanner.close();
    }

}
