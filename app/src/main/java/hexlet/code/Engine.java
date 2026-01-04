package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int ROUNDS_COUNT = 3;
    
    public static void start(Game game) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
        
        System.out.println(game.getRules());
        
        for (int i = 0; i < ROUNDS_COUNT; i++) {
            String[] questionAndAnswer = game.generateQuestion();
            String question = questionAndAnswer[0];
            String correctAnswer = questionAndAnswer[1];
            
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            
            String userAnswer = scanner.nextLine().trim();
            
            if (!userAnswer.equals(correctAnswer)) {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. "
                    + "Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                scanner.close();
                return;
            }
            
            System.out.println("Correct!");
        }
        
        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
    }
}
