import java.util.Scanner;

public class Daa4 {

    static boolean isSafe(int[][] board, int row, int col, int n) {

        // Check the same column above the current row
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    static boolean solveNQueens(int[][] board, int row, int n) {

        // All queens have been placed
        if (row == n) {
            return true;
        }

        // Try each column in the current row
        for (int col = 0; col < n; col++) {

            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;

                if (solveNQueens(board, row + 1, n)) {
                    return true;
                }

                // Backtrack
                board[row][col] = 0;
            }
        }

        return false;
    }

    static void printBoard(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = sc.nextInt();

        int[][] board = new int[n][n];

        System.out.print("Enter first queen's row and column (1-based): ");
        int row = sc.nextInt() - 1;
        int col = sc.nextInt() - 1;

        // Validate the first queen's position
        if (row < 0 || row >= n || col < 0 || col >= n) {
            System.out.println("Invalid position!");
            sc.close();
            return;
        }

        board[row][col] = 1;

        // Check whether the first queen is safe
        if (!isSafe(board, row, col, n)) {
            System.out.println("Invalid initial queen position!");
        } else if (solveNQueens(board, 0, n)) {
            System.out.println("Solution:");
            printBoard(board, n);
        } else {
            System.out.println("No solution exists for this initial position.");
        }

        sc.close();
    }
}