package SearchingAlgorithms;

import java.util.Scanner;

public class BinarySearch {

    private int search(int[] arr, int target) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            }
            if (arr[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearch bs = new BinarySearch();
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        System.out.print("Enter the target: ");
        int target = sc.nextInt();
        int index = bs.search(arr, target);
        System.out.println((index == -1) ? "Not Found" : "Found at index " + index);
    }
}
