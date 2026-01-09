package hexlet.code;

import java.util.Random;

public class Gcd implements Game {
    private static final int MAX_NUMBER = 100;
    private final Random random = new Random();
    
    @Override
    public String getRules() {
        return "Find the greatest common divisor of given numbers.";
    }
    
    @Override
    public String[] generateQuestion() {
        int a = random.nextInt(MAX_NUMBER) + 1; // +1 чтобы избежать 0
        int b = random.nextInt(MAX_NUMBER) + 1;
        
        int gcd = findGcd(a, b);
        
        return new String[]{a + " " + b, String.valueOf(gcd)};
    }
    
    // Метод для нахождения НОД (алгоритм Евклида)
    private int findGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
