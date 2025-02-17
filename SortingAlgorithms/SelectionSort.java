package SortingAlgorithms;

public class SelectionSort {

    // Time Complexity: O(n^2)
    // Stable: ❌ No
    // Approach: Selects the minimum element and swaps it with the current position.

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

}
