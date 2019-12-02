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
    /* This function prints current board state on screen */
    public void printBoard(int[][] boardData) {
        String line1 = "╔" + "══════" +                        "╦"+                       "══════"+"╦"+                        "══════"+"╦"                       +"══════"+"╗";
        String line2 = "║" + createPaddings(boardData[0][0])  + "║"+createPaddings(boardData[0][1])+ "║"+createPaddings(boardData[0][2]) +"║"+ createPaddings(boardData[0][3]) +"║";
        String line3 = "╠" + "══════"                        + "╬"+                       "══════"+"╬"+                        "══════"+"╬"+                       "══════"+"╣";
        String line4 = "║" + createPaddings(boardData[1][0])  + "║"+createPaddings(boardData[1][1])+ "║"+createPaddings(boardData[1][2]) +"║"+ createPaddings(boardData[1][3]) +"║";
        String line5 = "╠" + "══════"                        + "╬"+                       "══════"+"╬"+                        "══════"+"╬"+                       "══════"+"╣";
        String line6 = "║" + createPaddings(boardData[2][0]) +  "║"+createPaddings(boardData[2][1])+ "║"+createPaddings(boardData[2][2]) +"║"+ createPaddings(boardData[2][3]) +"║";
        String line7 = "╠" + "══════" +                        "╬"+                       "══════"+"╬"+                        "══════"+"╬"+                       "══════"+"╣";
        String line8 = "║" + createPaddings(boardData[3][0]) +  "║"+createPaddings(boardData[3][1])+ "║"+createPaddings(boardData[3][3]) +"║"+ createPaddings(boardData[3][3]) +"║";
        String line9 = "╚" + "══════"                        + "╩"+                       "══════"+"╩"+                        "══════"+"╩"                       +"══════"+"╝";
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(line5);
        System.out.println(line6);
        System.out.println(line7);
        System.out.println(line8);
        System.out.println(line9);
    }
    /*for (int i = 0; i < boardData.length; i++) {
        for (int j = 0; j < boardData.length; j++) {
            int processingNumber = boardData[i][j];
            System.out.print("[");
            /* Prints number with left-right paddings depending on number value
            if(processingNumber < 10) {
                System.out.print("  " + processingNumber + " ");
            } else if (processingNumber < 100) {
                System.out.print(" " + processingNumber + " ");
            } else if (processingNumber < 1000) {
                System.out.print(" " + processingNumber);
            } else {
                System.out.print(processingNumber);
            }
            System.out.print("]");
        }
        System.out.println("");/*
    }
}
// Only for testing purposes, comment / remove after merge to complete version */
    public static void main(String[] args) {
        /* Just an example of game current state, feel free to change it */
        int[][] boardData = {
                {8, 4, 0 ,4},
                {2, 16, 0, 0},
                {0, 0, 0, 128},
                {0, 1024, 512, 0}
        };
        /* Same code will be written in calling class (NOT this) */
        BoardPrinter boardPrinter = new BoardPrinter();
        boardPrinter.printBoard(boardData);
        System.out.println("\n");
    }
}
