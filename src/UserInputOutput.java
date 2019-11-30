import java.util.Scanner;
public class UserInputOutput {

    public void endGame () {
        System.out.println("Congratulations!");
        System.out.println("Your score: ");
    }

    //public static void main(String[] args) {


    Game newGame = new Game();
    public char getUserInput(){
        Scanner move = new Scanner(System.in);
        System.out.println("Please move with letters: 'a' 's' 'd' or 'w'");
        char userInput = move.nextLine().charAt(0);
        return userInput;
    }


    }
//}