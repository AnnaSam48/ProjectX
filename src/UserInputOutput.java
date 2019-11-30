import java.util.Scanner;
public class UserInputOutput {
    public void endGame () {
        System.out.println("Congratulations!");
        System.out.println("Your score: ");
    }


    public char getUserInput(){
        Scanner move = new Scanner(System.in);
        System.out.println("Please move with letters: 'a' 's' 'd' or 'w'");
        char userInput = move.nextLine().charAt(0);
        return userInput;
    }

    public static void main(String[] args) {
        UserInputOutput userInputOutput = new UserInputOutput();
        System.out.println(userInputOutput.getUserInput());
        Game newGame = new Game();
    }
}