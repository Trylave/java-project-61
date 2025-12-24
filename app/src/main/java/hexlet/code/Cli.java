package hexlet.code;

import java.util.Scanner;

public final class Cli {
    
    private Cli() {
        // Приватный конструктор
    }
    
    public static void greetUser() {
        System.out.println("Welcome to the Brain Games!");
        String userName = getUserName();
        System.out.println("Hello, " + userName + "!");
    }
    
    public static String getUserName() {
        System.out.print("May I have your name? ");
        
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextLine()) {
                String name = scanner.nextLine().trim();
                return name.isEmpty() ? "Guest" : name;
            }
        } catch (Exception e) {
            // Игнорируем ошибки ввода
        }
        
        return "Guest";
    }
} 
