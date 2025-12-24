package hexlet.code;

import java.util.Scanner;
import java.util.Random;

public class EvenGame {
    private static final int ROUNDS_TO_WIN = 3;
    private static final int MAX_NUMBER = 100;
    
    // УБИРАЕМ статический Scanner!
    
    public static void play(String userName) {
        // Создаём локальный Scanner
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        
        int correctAnswers = 0;
        
        while (correctAnswers < ROUNDS_TO_WIN) {
            int number = new Random().nextInt(MAX_NUMBER);
            boolean isEven = number % 2 == 0;
            String correctAnswer = isEven ? "yes" : "no";
            
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            
            // Проверяем, есть ли ввод
            if (!scanner.hasNextLine()) {
                System.out.println("No input received!");
                break;
            }
            
            String userAnswer = scanner.nextLine().trim().toLowerCase();
            
            // Проверка на пустой ввод
            if (userAnswer.isEmpty()) {
                showLossMessage("(empty)", correctAnswer, userName);
                return;
            }
            
            if (!isValidAnswer(userAnswer)) {
                showLossMessage(userAnswer, correctAnswer, userName);
                return;
            }
            
            if (!userAnswer.equals(correctAnswer)) {
                showLossMessage(userAnswer, correctAnswer, userName);
                return;
            }
            
            System.out.println("Correct!");
            correctAnswers++;
        }
        
        if (correctAnswers == ROUNDS_TO_WIN) {
            System.out.println("Congratulations, " + userName + "!");
        }
        
        scanner.close();
    }
    
    private static boolean isValidAnswer(String answer) {
        return answer.equals("yes") || answer.equals("no");
    }
    
    private static void showLossMessage(String userAnswer, String correctAnswer, String userName) {
        System.out.println("'" + userAnswer + "' is wrong answer ;(. "
            + "Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + userName + "!");
    }
}
