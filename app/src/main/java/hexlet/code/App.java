package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 0:
                    System.out.println("Goodbye!");
                    break;
                case 1:
                    Cli.greetUser();
                    break;
                case 2:
                    Even.play();  // Меню вызывает игру, а не движок!
                    break;
                case 3:
                    Calc.play();
                    break;
                case 4:
                    Gcd.play();
                    break;
                case 5:
                    Progression.play();
                    break;
                case 6:
                    Prime.play();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }
}