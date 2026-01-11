package hexlet.code;

import java.util.Random;

public class Progression implements Game {
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;
    private static final int MIN_START = 1;
    private static final int MAX_START = 50;
    private static final int MIN_STEP = 1;
    private static final int MAX_STEP = 10;
    
    private final Random random = new Random();
    
    @Override
    public String getRules() {
        return "What number is missing in the progression?";
    }
    
    @Override
    public String[] generateQuestion() {
        // Генерируем параметры прогрессии
        int length = random.nextInt(MAX_LENGTH - MIN_LENGTH + 1) + MIN_LENGTH;
        int start = random.nextInt(MAX_START - MIN_START + 1) + MIN_START;
        int step = random.nextInt(MAX_STEP - MIN_STEP + 1) + MIN_STEP;
        int hiddenIndex = random.nextInt(length);
        
        // Создаём прогрессию
        String[] progression = generateProgression(start, step, length);
        String hiddenNumber = progression[hiddenIndex];
        
        // Заменяем скрытое число на ".."
        progression[hiddenIndex] = "..";
        
        // Формируем вопрос
        String question = String.join(" ", progression);
        
        return new String[]{question, hiddenNumber};
    }
    
    private String[] generateProgression(int start, int step, int length) {
        String[] progression = new String[length];
        
        for (int i = 0; i < length; i++) {
            // Формула арифметической прогрессии: a_n = a_1 + (n-1) * d
            int currentElement = start + i * step;
            progression[i] = String.valueOf(currentElement);
        }
        
        return progression;
    }
}
