package SearchingAlgorithms;

import java.util.Scanner;

public class TernarySearch {

    private int search(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        return search(arr, target, low, high);
    }

    private int search(int[] arr, int target, int low, int high) {
        if (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;

            if(arr[mid1] == target) {
                return mid1;
            }
            if(arr[mid2] == target) {
                return mid2;
            }
            else if (target < arr[mid1]) {
                return search(arr, target, low, mid1-1);
            }
            else if (target > arr[mid2]) {
                return search(arr, target, mid2+1, high);
            }
            else {
                return search(arr, target, mid1+1, mid2-1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TernarySearch ts = new TernarySearch();
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        System.out.print("Enter the target: ");
        int target = sc.nextInt();
        int index = ts.search(arr, target);
        System.out.println((index == -1) ? "Not Found" : "Found at index " + index);
    }
}
