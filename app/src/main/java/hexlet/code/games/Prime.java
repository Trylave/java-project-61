package hexlet.code;

import java.util.Random;

public class Prime implements Game {
    private static final int MAX_NUMBER = 100;
    private final Random random = new Random();
    
    @Override
    public String getRules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }
    
    @Override
    public String[] generateQuestion() {
        int number = random.nextInt(MAX_NUMBER) + 1;
        boolean isPrime = isPrime(number);
        String correctAnswer = isPrime ? "yes" : "no";
        
        return new String[]{String.valueOf(number), correctAnswer};
    }
    
    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
