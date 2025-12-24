package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            
            // КРИТИЧЕСКИ ВАЖНО: очищаем буфер
            scanner.nextLine();
            
            switch (choice) {
                case 0:
                    System.out.println("Goodbye!");
                    break;
                case 1:
                    Cli.greetUser();
                    break;
                case 2:
                    // Получаем имя пользователя
                    System.out.print("May I have your name? ");
                    String userName = scanner.nextLine();
                    System.out.println("Hello, " + userName + "!");
                    
                    // Запускаем игру
                    EvenGame.play(userName);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        
        scanner.close();
    }
}
