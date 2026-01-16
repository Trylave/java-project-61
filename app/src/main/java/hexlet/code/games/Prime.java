package hexlet.code;

import java.util.Random;

public class Prime implements Game {
    private static final int ROUNDS_COUNT = 3;
    private static final int MAX_NUMBER = 100;
    
    @Override
    public String getRules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }
    
    @Override
    public String[][] getQuestions() {
        String[][] questions = new String[ROUNDS_COUNT][2];
        Random random = new Random();
        
        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int number = random.nextInt(MAX_NUMBER) + 1;
            boolean isPrime = isPrime(number);
            String correctAnswer = isPrime ? "yes" : "no";
            
            questions[i][0] = String.valueOf(number);
            questions[i][1] = correctAnswer;
        }
        
        return questions;
    }
    
    private boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
    
    // ВАЖНО: добавляем статический метод play()
    public static void play() {
        Prime game = new Prime();
        Engine.start(game.getRules(), game.getQuestions());
    }
}
