
import java.util.*;

class Daa4 {

    private boolean isValid(int row, int col, int n, char[][] board) {

        int currX = row;
        int currY = col;

        // Check upper-left diagonal
        while (currX >= 0 && currY >= 0) {
            if (board[currX][currY] == 'Q')
                return false;

            currX--;
            currY--;
        }

        currX = row;
        currY = col;

        // Check the same row towards the left
        while (currY >= 0) {
            if (board[currX][currY] == 'Q')
                return false;

            currY--;
        }

        currX = row;
        currY = col;

        // Check lower-left diagonal
        while (currX < n && currY >= 0) {
            if (board[currX][currY] == 'Q')
                return false;

            currX++;
            currY--;
        }

        return true;
    }

    private void solve(int col, char[][] board,
                       List<List<String>> ans, int n) {

        // All queens have been placed
        if (col == n) {
            List<String> configuration = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                configuration.add(new String(board[i]));
            }

            ans.add(configuration);
            return;
        }

        // Try placing a queen in each row of the current column
        for (int row = 0; row < n; row++) {

            if (isValid(row, col, n, board)) {

                board[row][col] = 'Q';

                solve(col + 1, board, ans, n);

                // Backtrack
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, board, ans, n);

        return ans;
    }
}