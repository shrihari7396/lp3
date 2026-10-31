import java.util.Scanner;

public class Daa1 {

    // Recursive Fibonacci
    static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Non-recursive (Iterative) Fibonacci
    static void fibonacciIterative(int n) {
        int a = 0, b = 1;

        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");

            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of terms: ");
        int n = sc.nextInt();

        // Recursive approach
        System.out.println("Recursive Fibonacci:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciRecursive(i) + " ");
        }

        System.out.println();

        // Non-recursive approach
        System.out.println("Non-Recursive Fibonacci:");
        fibonacciIterative(n);

        sc.close();
    }
}