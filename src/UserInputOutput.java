import java.util.Scanner;

public class UserInputOutput {



    public String getUserInput() {
        Scanner move = new Scanner(System.in);
        System.out.println("Please move with letters: 'a' 's' 'd' or 'w'");
        String userInput = move.next();
        return userInput;
    }

    public void endGame(int score) {
        System.out.println("Congratulations!");
        System.out.println("Your score: " + score);
        System.exit(0);
    }
}
