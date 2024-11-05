import java.util.Scanner;
public class TicTacToe {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String[][] board = new String[ROWS][COLS];
    private static String currentPlayer = "X";

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        boolean playAgain;

        do {
            clearBoard();
            playGame(console);
            playAgain = SafeInput.getYNConfirm(console, "Do you want to play again?");
        } while (playAgain);

        console.close();
    }

    private static void playGame(Scanner console) {
        int moveCounter = 0;
        boolean gameWon = false;

        while (!gameWon && moveCounter < ROWS * COLS) {
            display();
            int row = SafeInput.getRangedInt(console, "Enter row (1-3): ", 1, 3) - 1;
            int col = SafeInput.getRangedInt(console, "Enter column (1-3): ", 1, 3) - 1;

            while (!isValidMove(row, col)) {
                System.out.println("Invalid move. Try again.");
                row = SafeInput.getRangedInt(console, "Enter row (1-3): ", 1, 3) - 1;
                col = SafeInput.getRangedInt(console, "Enter column (1-3): ", 1, 3) - 1;
            }

            board[row][col] = currentPlayer;
            moveCounter++;

            if (isWin(currentPlayer)) {
                display();
                System.out.println("Player " + currentPlayer + " wins!");
                gameWon = true;
            } else if (isTie()) {
                display();
                System.out.println("It's a tie!");
                break;
            }

            togglePlayer();
        }
    }

    private static void clearBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = " ";
            }
        }
    }

    private static void display() {
        System.out.println("Current Board:");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < COLS - 1) System.out.print("|");
            }
            System.out.println();
            if (i < ROWS - 1) System.out.println("---+---+---");
        }
    }

    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }

    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    private static boolean isRowWin(String player) {
        for (int i = 0; i < ROWS; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isColWin(String player) {
        for (int j = 0; j < COLS; j++) {
            if (board[0][j].equals(player) && board[1][j].equals(player) && board[2][j].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    private static boolean isTie() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return !isWin("X") && !isWin("O");
    }

    private static void togglePlayer() {
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }
}
