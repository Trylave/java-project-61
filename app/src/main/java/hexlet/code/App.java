package hexlet.code;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
	System.out.println("3 - Calc");
	System.out.println("4 - GCD");
	System.out.println("5 - Progression");
	System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            
            // КРИТИЧЕСКИ ВАЖНО: очищаем буфер
            scanner.nextLine();
            
            switch (choice) {
                case 0:
                    System.out.println("Goodbye!");
                    break;
                case 1:
                    Cli.greetUser();
                    break;
                case 2:
                    Engine.start(new Even());
                    break;
		case 3:
		    Engine.start(new Calc());
                    break;
		case 4:
                    Engine.start(new Gcd());
                    break;
		case 5:
                    Engine.start(new Progression());
                    break;
		case 6:
                    Engine.start(new Prime());
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        
        scanner.close();
    }
}
