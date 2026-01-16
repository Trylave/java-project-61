package hexlet.code;

import java.util.Random;

public class Gcd implements Game {
    private static final int ROUNDS_COUNT = 3;
    private static final int MAX_NUMBER = 100;
    
    @Override
    public String getRules() {
        return "Find the greatest common divisor of given numbers.";
    }
    
    @Override
    public String[][] getQuestions() {
        String[][] questions = new String[ROUNDS_COUNT][2];
        Random random = new Random();
        
        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int a = random.nextInt(MAX_NUMBER) + 1;
            int b = random.nextInt(MAX_NUMBER) + 1;
            int gcd = findGcd(a, b);
            
            questions[i][0] = a + " " + b;
            questions[i][1] = String.valueOf(gcd);
        }
        
        return questions;
    }
    
    private int findGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static void play() {
        Gcd game = new Gcd();
        Engine.start(game.getRules(), game.getQuestions());
    }
}
