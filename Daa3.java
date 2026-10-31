import java.util.Scanner;

import  static  java.lang.Math.*;

public class Daa3 {

    static int knapsack(int[] weight, int[] value, int capacity, int n) {

        // Base case
        if (n == 0 || capacity == 0) {
            return 0;
        }

        // If current item exceeds capacity, exclude it
        if (weight[n - 1] > capacity) {
            return knapsack(weight, value, capacity, n - 1);
        }

        // Include or exclude the current item
        int include = value[n - 1]
                + knapsack(weight, value, capacity - weight[n - 1], n - 1);

        int exclude = knapsack(weight, value, capacity, n - 1);

        return Math.max(include, exclude);
    }

    static int knap(int[] wei, int[] val, int cap, int n) {
        if(n == 0 || cap == 0) {
            return 0;
        }

        if(wei[n - 1] > cap) {
            return knap(wei, val, cap, n - 1);
        }

        int include = val[n-1] + knap(wei, val, cap - wei[n - 1], n - 1);
        int exclude = knap(wei, val, cap, n - 1);

        return max(include, exclude);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];

        System.out.println("Enter weights of items:");
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        System.out.println("Enter values of items:");
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        System.out.println("Maximum value: "
                + knapsack(weight, value, capacity, n));

        sc.close();
    }
}