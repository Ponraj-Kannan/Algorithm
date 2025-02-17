package SearchingAlgorithms;

import java.util.Scanner;

public class InterpolationSearch {

    private int search(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        return search(arr, target, lo, hi);
    }

    private int search(int[] arr, int x, int lo, int hi) {
        if (lo <= hi && x >= arr[lo] && x <= arr[hi]) {
            int  pos = lo + (((hi - lo) * (x - arr[lo])) / (arr[hi] - arr[lo]));
            if(arr[pos] == x){
                return pos;
            }
            else if(arr[pos] < x){
                return search(arr, x, pos+1, hi);
            }
            else{
                return search(arr, x, lo, pos-1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InterpolationSearch is = new InterpolationSearch();
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        System.out.print("Enter the target: ");
        int target = sc.nextInt();
        int index = is.search(arr, target);
        System.out.println((index == -1) ? "Not Found" : "Found at index " + index);
    }
}
