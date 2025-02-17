package GreedyAlgorithm;

import java.util.Arrays;

public class CoinChange {

    // Function to find the minimum number of coins required
    public static void findMinCoins(int[] coins, int amount) {
        // Sort the coins in descending order
        Arrays.sort(coins);
        reverseArray(coins);

        // Initialize the result list to store the coins used
        int[] result = new int[coins.length];
        int index = 0;

        // Traverse through all the coins
        for (int coin : coins) {
            // Use as many of the current coin as possible
            while (amount >= coin) {
                result[index] = result[index] + 1;
                amount -= coin;
            }
            index++;
        }

        // If amount is not zero, it means it's not possible to make the change
        if (amount != 0) {
            System.out.println("It's not possible to make the change with the given coins.");
        } else {
            // Print the result
            System.out.println("Coins used to make the change:");
            for (int i = 0; i < index; i++) {
                if(result[i] != 0){
                    for (int j = 0; j < result[i]; j++) {
                        System.out.print(coins[i] + " ");
                    }
                }
            }
        }
    }

    // Helper function to reverse the array
    private static void reverseArray(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000}; // Coin denominations
        int amount = 2060; // Amount to make change for

        findMinCoins(coins, amount);
    }
}
