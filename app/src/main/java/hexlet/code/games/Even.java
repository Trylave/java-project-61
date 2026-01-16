package hexlet.code;

import java.util.Random;

public class Even implements Game {
    private static final int ROUNDS_COUNT = 3;
    private static final int MAX_NUMBER = 100;
    
    @Override
    public String getRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }
    
    @Override
    public String[][] getQuestions() {
        String[][] questions = new String[ROUNDS_COUNT][2];
        Random random = new Random();
        
        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int number = random.nextInt(MAX_NUMBER);
            boolean isEven = number % 2 == 0;
            String correctAnswer = isEven ? "yes" : "no";
            
            questions[i][0] = String.valueOf(number);
            questions[i][1] = correctAnswer;
        }
        
        return questions;
    }
    
    // ВАЖНО: добавляем статический метод play()
    public static void play() {
        Even game = new Even();
        Engine.start(game.getRules(), game.getQuestions());
    }
}
