package SearchingAlgorithms;

import java.util.Scanner;

public class LinearSearch {

    private int search(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinearSearch ls = new LinearSearch();
        int[] arr = {10, 90, 20, 80, 30, 70, 40, 60, 50};
        System.out.print("Enter the target: ");
        int target = sc.nextInt();
        int index = ls.search(arr, target);
        System.out.println((index == -1) ? "Not Found" : "Found at index " + index);
    }
}
