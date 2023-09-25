

import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        displayBoard();

        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver) {
            int[] move = getPlayerMove(scanner);
            int row = move[0];
            int col = move[1];

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                displayBoard();
                gameOver = isGameWon() || isBoardFull();
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        if (isGameWon()) {
            System.out.println("Player " + currentPlayer + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private static void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
    }

    private static void displayBoard() {
        System.out.println("  0 1 2");
        for (int row = 0; row < 3; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col]);
                if (col < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (row < 2) {
                System.out.println("  -+-+-");
            }
        }
    }

    private static int[] getPlayerMove(Scanner scanner) {
        System.out.print("Player " + currentPlayer + ", enter your move (row and column): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[]{row, col};
    }

    private static boolean isValidMove(int row, int col) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ');
    }

    private static boolean isGameWon() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return true; // Row win
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return true; // Column win
            }
        }
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return true; // Diagonal (top-left to bottom-right) win
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return true; // Diagonal (top-right to bottom-left) win
        }
        return false;
    }

    private static boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false; // There is an empty cell
                }
            }
        }
        return true; // The board is full (draw)
    }
}
