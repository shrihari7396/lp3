import java.util.Arrays;
import java.util.Random;

public class Daa5 {

    static Random random = new Random();

    // Deterministic Quick Sort
    static int partition(int[] arr, int low, int high, boolean randomized) {

        int pivotIndex = high;

        if (randomized) {
            pivotIndex = low + random.nextInt(high - low + 1);

            int temp = arr[pivotIndex];
            arr[pivotIndex] = arr[high];
            arr[high] = temp;
        }

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void quickSort(int[] arr, int low, int high, boolean randomized) {
        if (low < high) {
            int p = partition(arr, low, high, randomized);

            quickSort(arr, low, p - 1, randomized);
            quickSort(arr, p + 1, high, randomized);
        }
    }

    public static void main(String[] args) {

        int[] arr1 = {8, 3, 1, 7, 0, 10, 2};
        int[] arr2 = arr1.clone();

        quickSort(arr1, 0, arr1.length - 1, false);
        quickSort(arr2, 0, arr2.length - 1, true);

        System.out.println("Deterministic Quick Sort: " + Arrays.toString(arr1));
        System.out.println("Randomized Quick Sort: " + Arrays.toString(arr2));
    }
}
