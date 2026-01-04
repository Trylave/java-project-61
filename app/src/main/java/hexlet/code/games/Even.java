package hexlet.code;

import java.util.Random;

public class Even implements Game {
    private static final int MAX_NUMBER = 100;
    private final Random random = new Random();
    
    @Override
    public String getRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }
    
    @Override
    public String[] generateQuestion() {
        int number = random.nextInt(MAX_NUMBER);
        boolean isEven = isEven(number);
        String correctAnswer = isEven ? "yes" : "no";
        
        return new String[]{String.valueOf(number), correctAnswer};
    }
    
    // Предикат для проверки на чётность
    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
