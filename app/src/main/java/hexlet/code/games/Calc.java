package hexlet.code;

import java.util.Random;

public class Calc implements Game {
    private static final int ROUNDS_COUNT = 3;
    private static final int MAX_NUMBER = 100;
    
    @Override
    public String getRules() {
        return "What is the result of the expression?";
    }
    
    @Override
    public String[][] getQuestions() {
        String[][] questions = new String[ROUNDS_COUNT][2];
        Random random = new Random();
        
        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int a = random.nextInt(MAX_NUMBER);
            int b = random.nextInt(MAX_NUMBER);
            char operator = getRandomOperator();
            String correctAnswer = calculate(a, b, operator);
            String question = a + " " + operator + " " + b;
            
            questions[i][0] = question;
            questions[i][1] = correctAnswer;
        }
        
        return questions;
    }
    
    private char getRandomOperator() {
        char[] operators = {'+', '-', '*'};
        Random random = new Random();
        return operators[random.nextInt(operators.length)];
    }
    
    private String calculate(int a, int b, char operator) {
        return switch (operator) {
            case '+' -> String.valueOf(a + b);
            case '-' -> String.valueOf(a - b);
            case '*' -> String.valueOf(a * b);
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };
    }
    
    public static void play() {
        Calc game = new Calc();
        Engine.start(game.getRules(), game.getQuestions());
    }
}
