import java.util.Scanner;

public class UserInputOutput {

    int score;

    public String getUserInput() {
        Scanner move = new Scanner(System.in);
        System.out.println("Please move with letters: 'a' 's' 'd' or 'w'");
        String userInput = move.next();
        return userInput;
    }

    public void endGame() {
        System.out.println("Congratulations!");
        System.out.println("Your score: " + score);
    }
}
