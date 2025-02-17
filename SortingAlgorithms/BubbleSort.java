package SortingAlgorithms;

public class BubbleSort {

    // Time Complexity: O(n^2) (worst and average case), O(n) (best case, if already sorted)
    // Stable: ✅ Yes
    // Approach: Repeatedly swaps adjacent elements if they are in the wrong order.

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimization: Stop if already sorted
        }
    }
}
