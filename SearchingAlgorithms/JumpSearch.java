package SearchingAlgorithms;

import java.util.Scanner;

public class JumpSearch {

    private int search(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = (int)Math.sqrt(n);
        while (arr[Math.min(high, n) - 1] < target) {
            low = high;
            high += (int)Math.sqrt(n);
            if(low >= n){
                return -1;
            }
        }
        for (int i = low; i <= high && i < n; i++) {
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JumpSearch js = new JumpSearch();
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        System.out.print("Enter the target: ");
        int target = sc.nextInt();
        int index = js.search(arr, target);
        System.out.println((index == -1) ? "Not Found" : "Found at index " + index);
    }
}
