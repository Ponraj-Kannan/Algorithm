package SearchingAlgorithms;

import java.util.Scanner;

public class SentinelLinearSearch {

    private int search(int[] arr, int target) {
        int n = arr.length;
        int last = arr[n - 1];
        arr[n - 1] = target;
        int i = 0;
        while (arr[i] != target)
            i++;

        arr[n-1] = last;
        if(i < n-1 || arr[n-1] == target){
            return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SentinelLinearSearch sls = new SentinelLinearSearch();
        int[] arr = {10, 90, 20, 80, 30, 70, 40, 60, 50};
        System.out.print("Enter the target: ");
        int target = sc.nextInt();
        int index = sls.search(arr, target);
        System.out.println((index == -1) ? "Not Found" : "Found at index " + index);
    }
}
