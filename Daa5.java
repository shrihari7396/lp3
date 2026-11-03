import java.util.Arrays;
import java.util.Random;

public class Daa5 {

    static Random random = new Random();

    // Deterministic Quick Sort
    static int partition(int[] arr, int low, int high, boolean randomized) {
        int pivotIndex = high;

        if (randomized) {
            pivotIndex = low + random.nextInt(high - low + 1);
            int temp = arr[high];
            arr[high] = arr[pivotIndex];
            arr[pivotIndex] = temp;
        }

        int pivot = arr[high];

        int i = low;
        int j = high - 1;

        while (i <= j) {
            while (i <= j && arr[i] <= pivot) {
                i++;
            }

            while (i <= j && arr[j] > pivot) {
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }

        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        // Pivot is now at index i
        return i;
    }

    static void quickSort(int[] arr, int low, int high, boolean randomized) {
        if (low < high) {
            int p = partition(arr, low, high, randomized);

            quickSort(arr, low, p - 1, randomized);
            quickSort(arr, p + 1, high, randomized);
        }
    }

    static int partition1(int[] arr, int low, int high, boolean randomized) {
        int pivotIndex = high;

        if (randomized) {
            pivotIndex = low + random.nextInt(high - low + 1);
            int temp = arr[high];
            arr[high] = arr[pivotIndex];
            arr[pivotIndex] = temp;

        }

        int pivot = arr[high];
        int i = low, j = high - 1;

        while(low <= high) {
            while(i <= j && arr[i] <= pivot) {
                i++;
            }

            while(i <= j && arr[j] > pivot) {
                j--;
            }

            if(i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        int temp = arr[high];
        arr[high] = arr[i];
        arr[i] = temp;
        return i;
    }

    static void sort(int[] arr, int low, int high, boolean randomized) {
        if (low < high) {
            int p = partition1(arr, low, high, randomized);
            sort(arr, low, p - 1, randomized);
            sort(arr, p + 1, high, randomized);
        }
    }

    public static void main(String[] args) {

        int[] arr1 = { 8, 3, 1, 7, 0, 10, 2 };
        int[] arr2 = arr1.clone();

        sort(arr1, 0, arr1.length - 1, false);
        sort(arr2, 0, arr2.length - 1, true);

        System.out.println("Deterministic Quick Sort: " + Arrays.toString(arr1));
        System.out.println("Randomized Quick Sort: " + Arrays.toString(arr2));
    }
}
