package hexlet.code;

import java.util.Random;

public class Progression implements Game {
    private static final int ROUNDS_COUNT = 3;
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;
    private static final int MIN_START = 1;
    private static final int MAX_START = 50;
    private static final int MIN_STEP = 1;
    private static final int MAX_STEP = 10;
    
    @Override
    public String getRules() {
        return "What number is missing in the progression?";
    }
    
    @Override
    public String[][] getQuestions() {
        String[][] questions = new String[ROUNDS_COUNT][2];
        Random random = new Random();
        
        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int length = random.nextInt(MAX_LENGTH - MIN_LENGTH + 1) + MIN_LENGTH;
            int start = random.nextInt(MAX_START - MIN_START + 1) + MIN_START;
            int step = random.nextInt(MAX_STEP - MIN_STEP + 1) + MIN_STEP;
            int hiddenIndex = random.nextInt(length);
            
            String[] progression = generateProgression(start, step, length);
            String hiddenNumber = progression[hiddenIndex];
            progression[hiddenIndex] = "..";
            String question = String.join(" ", progression);
            
            questions[i][0] = question;
            questions[i][1] = hiddenNumber;
        }
        
        return questions;
    }
    
    private String[] generateProgression(int start, int step, int length) {
        String[] progression = new String[length];
        for (int i = 0; i < length; i++) {
            progression[i] = String.valueOf(start + i * step);
        }
        return progression;
    }
    
    public static void play() {
        Progression game = new Progression();
        Engine.start(game.getRules(), game.getQuestions());
    }
}
