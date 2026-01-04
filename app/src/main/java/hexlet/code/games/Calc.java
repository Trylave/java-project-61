package hexlet.code;

import java.util.Random;

public class Calc implements Game {
    private static final int MAX_NUMBER = 100;
    private final Random random = new Random();
    
    @Override
    public String getRules() {
        return "What is the result of the expression?";
    }
    
    @Override
    public String[] generateQuestion() {
        int a = random.nextInt(MAX_NUMBER);
        int b = random.nextInt(MAX_NUMBER);
        char operator = getRandomOperator();
        
        String question = a + " " + operator + " " + b;
        String correctAnswer = calculate(a, b, operator);
        
        return new String[]{question, correctAnswer};
    }
    
    private char getRandomOperator() {
        char[] operators = {'+', '-', '*'};
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
}
