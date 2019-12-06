public class BoardPrinter {
    private String createPaddings(int number) {
        String longerNumber;
        if (number == 0) {
            longerNumber = "      ";
        } else if (number < 10) {
            longerNumber = "   " + number + "  ";
        } else if (number < 100) {
            longerNumber = "  " + number + "  ";
        } else if (number < 1000) {
            longerNumber = "  " + number + " ";
        } else {
            longerNumber = " " + number + " ";
        }
        return longerNumber;
    }

    public void printBoard(int[][] board, int score) {
        String line1 = "╔" + "══════" + "╦" + "══════" + "╦" + "══════" + "╦" + "══════" + "╗";
        String line2 = "║" + createPaddings(board[0][0]) + "║" + createPaddings(board[0][1]) + "║" + createPaddings(board[0][2]) + "║" + createPaddings(board[0][3]) + "║";
        String line3 = "╠" + "══════" + "╬" + "══════" + "╬" + "══════" + "╬" + "══════" + "╣";
        String line4 = "║" + createPaddings(board[1][0]) + "║" + createPaddings(board[1][1]) + "║" + createPaddings(board[1][2]) + "║" + createPaddings(board[1][3]) + "║";
        String line5 = "╠" + "══════" + "╬" + "══════" + "╬" + "══════" + "╬" + "══════" + "╣";
        String line6 = "║" + createPaddings(board[2][0]) + "║" + createPaddings(board[2][1]) + "║" + createPaddings(board[2][2]) + "║" + createPaddings(board[2][3]) + "║";
        String line7 = "╠" + "══════" + "╬" + "══════" + "╬" + "══════" + "╬" + "══════" + "╣";
        String line8 = "║" + createPaddings(board[3][0]) + "║" + createPaddings(board[3][1]) + "║" + createPaddings(board[3][2]) + "║" + createPaddings(board[3][3]) + "║";
        String line9 = "╚" + "══════" + "╩" + "══════" + "╩" + "══════" + "╩" + "══════" + "╝";
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(line5);
        System.out.println(line6);
        System.out.println(line7);
        System.out.println(line8);
        System.out.println(line9);
        System.out.println("score = " + score);
    }

//    BoardPrinter boardPrinter = new BoardPrinter();
//        boardPrinter.printBoard(boardData);
//        System.out.println("\n");
}
