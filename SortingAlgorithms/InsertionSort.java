package SortingAlgorithms;

public class InsertionSort {

    // Time Complexity: O(n^2) (worst and average), O(n) (best)
    // Stable: ✅ Yes
    // Approach: Builds the sorted array one element at a time.

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

}
