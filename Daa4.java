import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Daa4 {

    private static boolean isValid(int row, int col, char[][] board) {
        int n = board.length;

        // Check upper-left diagonal
        int x = row;
        int y = col;

        while (x >= 0 && y >= 0) {
            if (board[x][y] == 'x') {
                return false;
            }
            x--;
            y--;
        }

        // Check same row towards the left
        x = row;
        y = col;

        while (y >= 0) {
            if (board[x][y] == 'x') {
                return false;
            }
            y--;
        }

        // Check lower-left diagonal
        x = row;
        y = col;

        while (x < n && y >= 0) {
            if (board[x][y] == 'x') {
                return false;
            }
            x++;
            y--;
        }

        return true;
    }

    private static void solve(int col, char[][] board,
                       List<List<String>> ans, int n) {

        // All queens have been placed
        if (col == n) {
            List<String> configs = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                configs.add(new String(board[i]));
            }

            ans.add(configs);
            return;
        }

        // Try placing a queen in every row of this column
        for (int row = 0; row < n; row++) {

            if (isValid(row, col, board)) {

                // Place queen
                board[row][col] = 'x';

                // Move to the next column
                solve(col + 1, board, ans, n);

                // Backtrack
                board[row][col] = '.';
            }
        }
    }

    public static  List<List<String>> solve(int n) {
        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // Start from column 0
        solve(0, board, ans, n);
        int count = 0;
        for (List<String> list : ans) {
            System.out.println("Permutation Number:" + count);
            for(String s : list) {
                for(int i = 0; i < s.length(); i++) {
                    char  ch = s.charAt(i);
                    System.out.print(ch + "  ");
                }
                System.out.println(" ");
            }
            System.out.println(" ");
            count++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int n;
        System.out.print("Enter Number of the Rows and Columns Should be present in the Chess: ");
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
            solve(n);
        }
    }
}
