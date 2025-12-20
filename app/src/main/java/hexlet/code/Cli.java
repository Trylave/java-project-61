package hexlet.code;

import java.util.Scanner;

public class Cli {
	private Cli() {
        // Приватный конструктор для утилитарного класса
    }
    	public static void greetUser() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextLine()) {
                String name = scanner.nextLine();
                System.out.println("Hello, " + name + "!");
            } else {
                System.out.println("Hello!");
            }
        } catch (Exception e) {
            System.out.println("Hello, Guest!");
        }
    }
}
